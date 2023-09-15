export class Question {
  // id!: number;
  type: string;
  text: string;
  options: string[];

  constructor(
    id: number,
    text: string,
    options: string[],
    type: string = 'multiple'
  ) {
    this.text = text;
    this.options = options;
    this.type = type;
    // this.id = id;
  }
}
