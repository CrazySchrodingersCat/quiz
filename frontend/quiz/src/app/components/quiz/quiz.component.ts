import { Component, OnInit } from '@angular/core';
import { QuizService } from 'src/app/services/quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css'],
})
export class QuizComponent implements OnInit {
  fetchedData!: any;
  questions!: any;

  constructor(private quizService: QuizService) {}

  ngOnInit(): void {
    this.getQuestions();
  }
  getQuestions() {
    this.quizService.getQuestions().subscribe((data) => {
      this.questions = data;
    });
  }
 
}
