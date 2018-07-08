export class Comment {
    author: string;
    text: string;
    time: Date;

    constructor(text: string) {
        this.author = 'Unknown';
        this.text = text;
    }
}