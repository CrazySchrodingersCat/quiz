import { Component, OnInit } from '@angular/core';
import { Question } from 'src/app/models/question.model';
import { QuizService } from 'src/app/services/quiz.service';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css'],
})
export class QuizComponent implements OnInit {
  QuestionsList: Question[] = [
    {
      // id: 1,
      type: 'multiple',
      text:
        'Which of the following African countries was most successful in resisting colonization?',
      options: ['Ethiopia', 'C&ocirc;te d&rsquo;Ivoire', 'Congo', 'Namibia'],
    },
    {
      // id: 2,
      type: 'boolean',
      text: 'Donkey Kong was originally set to be a Popeye arcade game.',
      options: ['False', 'True'],
    },
  ];
  fetchedData!: any;
  questions!: any;

  constructor(private quizService: QuizService) {}

  ngOnInit(): void {
    this.getQuestions();
  }
  getQuestions() {
    this.quizService.getQuestions().subscribe((data) => {
      this.questions = data;
      // console.log(this.questions);
    });
  }
 
}
