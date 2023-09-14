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
      id: 1,
      type: 'multiple',
      question:
        'Which of the following African countries was most successful in resisting colonization?',
      options: ['Ethiopia', 'C&ocirc;te d&rsquo;Ivoire', 'Congo', 'Namibia'],
    },
    {
      id: 2,
      type: 'boolean',
      question: 'Donkey Kong was originally set to be a Popeye arcade game.',
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
      console.log(data);
      this.fetchedData = data;
      this.questions = this.fetchedData.results;
      console.log(this.questions);
    });
  }
 
}
