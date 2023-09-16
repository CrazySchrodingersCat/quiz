import {
  Component,
  Input,
  OnInit,
} from '@angular/core';
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
  selectedAnswer: string = '';
  isSelected: boolean = false;
  isCorrect: boolean = false;

  constructor(private quizService: QuizService) {}
  ngOnInit(): void {}
  checkAnswer() {
    this.quizService
      .checkAnswer(new Answer(this.question.text, this.selectedAnswer))
      .subscribe((data) => {
        this.isCorrect = data.result;
      });
    this.isSelected = true;
  }
}
