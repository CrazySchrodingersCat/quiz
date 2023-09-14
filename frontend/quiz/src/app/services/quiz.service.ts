import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class QuizService {
  private openDbUrl = 'https://opentdb.com/api.php?amount=5';
  private serverUrl = 'http://localhost:8080';

  constructor(private http: HttpClient) {}

  getQuestions() {
    // const url = `${this.serverUrl}/questions`; 
    return this.http.get(this.openDbUrl);
  }
  checkAnswer(id:number):Observable<any>{    
    return this.http.post(this.serverUrl + `/checkAnswers`, id);

  }
}
