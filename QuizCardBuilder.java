import java.io.File;

class QuizCardBuilder {
    private void nextCard() {

    }

    private void saveCard() {

    }

    private void saveFile(File file) {

    }
}

class QuizCard {
    private String question;
    private String answer;

    public QuizCard(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    String getQuestion() {
        return question;
    }

    String getAnswer() {
        return answer;
    }
}