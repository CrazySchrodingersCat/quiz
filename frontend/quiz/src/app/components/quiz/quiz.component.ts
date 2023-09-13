import { Component, OnInit } from '@angular/core';
import { Question } from 'src/app/models/question.model';

@Component({
  selector: 'app-quiz',
  templateUrl: './quiz.component.html',
  styleUrls: ['./quiz.component.css'],
})
export class QuizComponent implements OnInit {
  QuestionsList: Question[] = [
    {
      type: 'multiple',
      question:
        'Which of the following African countries was most successful in resisting colonization?',
      options: ['Ethiopia', 'C&ocirc;te d&rsquo;Ivoire', 'Congo', 'Namibia'],
    },
    {
      type: 'boolean',
      question: 'Donkey Kong was originally set to be a Popeye arcade game.',
      options: ['False', 'True'],
    },
  ];

  constructor() {}

  ngOnInit(): void {}
}
