export class Question {
  id!: number;
  type: string;
  question: string;
  options: string[];

  constructor(
    id: number,
    text: string,
    options: string[],
    type: string = 'multiple'
  ) {
    this.question = text;
    this.options = options;
    this.type = type;
    this.id = id;
  }
}
