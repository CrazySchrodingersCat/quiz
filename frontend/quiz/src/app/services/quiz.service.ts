import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import {Answer} from '../models/answer.model';

@Injectable({
  providedIn: 'root',
})
export class QuizService {
  //private openDbUrl = 'https://opentdb.com/api.php?amount=5';
  private serverUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getQuestions() { 
    return this.http.get(this.serverUrl+ `/questions`);
  }
  checkAnswer(answer:Answer):Observable<any>{    
    return this.http.post(this.serverUrl + `/checkanswers`, answer);

  }
}
