import { ChangeDetectionStrategy, Component, Input, OnInit } from '@angular/core';
import { Answer } from 'src/app/models/answer.model';
import { Question } from 'src/app/models/question.model';
import { QuizService } from 'src/app/services/quiz.service';

@Component({
  selector: 'app-question',
  templateUrl: './question.component.html',
  styleUrls: ['./question.component.css'],
 
  
})
export class QuestionComponent implements OnInit {
  @Input() question!: Question;
  selectedAnswer: string='';
  correctAnswer: string = 'Ethiopia';

  isSelected: boolean = false;
  isCorrect: boolean = false;

  constructor(private quizService: QuizService) {}
  ngOnInit(): void {
    
  }
  checkAnswer() {   
    let answer = new Answer(this.question.text,this.selectedAnswer);
    console.log(answer);
    
    this.quizService.checkAnswer(answer).subscribe((data) => {
      console.log(data);
      this.isCorrect = data.result;
    
    })
    console.log("SELECTED: " + this.selectedAnswer);
    if (this.selectedAnswer === this.correctAnswer) {
     
      this.isCorrect = true;
    } else {
      this.isCorrect = false;
    }
    this.isSelected = true;
  }
}
