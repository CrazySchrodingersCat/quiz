import { ChangeDetectionStrategy, Component, Input, OnInit } from '@angular/core';
import { Question } from 'src/app/models/question.model';

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

  constructor() {}

  ngOnInit(): void {
    
  }
  checkAnswer() {   
    console.log("SELECTED: " + this.selectedAnswer);
    if (this.selectedAnswer === this.correctAnswer) {
     
      this.isCorrect = true;
    } else {
      this.isCorrect = false;
    }
    this.isSelected = true;
  }
}
