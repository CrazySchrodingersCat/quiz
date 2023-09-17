import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { QuizComponent } from './components/quiz/quiz.component';
import { QuestionComponent } from './components/question/question.component';
import { MatButtonModule } from '@angular/material/button';
import { MatListModule } from '@angular/material/list';
import { MatRadioModule } from '@angular/material/radio';

import { MatSelectModule } from '@angular/material/select';
import { QuizService } from './services/quiz.service';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [AppComponent, QuizComponent, QuestionComponent],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    MatButtonModule,
    MatListModule,
    MatRadioModule,
    MatSelectModule,
  ],
  providers: [QuizService],
  bootstrap: [AppComponent],
})
export class AppModule {}
