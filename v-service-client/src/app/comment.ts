export class Comment {
    author: string;
    text: string;

    constructor(text: string) {
        this.author = 'Unknown';
        this.text = text;
    }
}