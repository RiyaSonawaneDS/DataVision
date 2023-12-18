import java.util.*;

class QuizQuestion {
    
    private String question;
    private List<String> options;
    private int correctAnswerIndex;

    public QuizQuestion(String question, List<String> options, int correctAnswerIndex) {
        this.question = question;
        this.options = options;
        this.correctAnswerIndex = correctAnswerIndex;
    }

    public String getQuestion() {
        return question;
    }

    public List<String> getOptions() {
        return options;
    }

    public int getCorrectAnswerIndex() {
        return correctAnswerIndex;
    }
}

class Quiz {
    private List<QuizQuestion> questions;
    private Scanner scanner;
    private int score;
    private int currentQuestionIndex;
    private Timer timer;

    public Quiz(List<QuizQuestion> questions) {
        this.questions = questions;
        this.scanner = new Scanner(System.in);
        this.score = 0;
        this.currentQuestionIndex = 0;
        this.timer = new Timer();
    }

    public void start() {
        if (currentQuestionIndex < questions.size()) {
            displayQuestion();
            startTimer();
            int selectedOption = scanner.nextInt();
            stopTimer();

            checkAnswer(selectedOption);
            currentQuestionIndex++;

            start();
        } else {
            displayResult();
        }
    }

    private void displayQuestion() {
        QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
        System.out.println("Question: " + currentQuestion.getQuestion());
        List<String> options = currentQuestion.getOptions();
        for (int i = 0; i < options.size(); i++) {
            System.out.println((i + 1) + ". " + options.get(i));
        }
        System.out.print("Choose an option: ");
    }

    private void startTimer() {
        TimerTask task = new TimerTask() {
            public void run() {
                System.out.println("\nTime's up!");
                scanner.nextLine(); // Clear input buffer
                stopTimer();
                currentQuestionIndex++;
                start();
            }
        };
        timer.schedule(task, 10000); // 10 seconds for each question
    }

    private void stopTimer() {
        timer.cancel();
        timer.purge();
    }

    private void checkAnswer(int selectedOption) {
        QuizQuestion currentQuestion = questions.get(currentQuestionIndex);
        if (selectedOption == currentQuestion.getCorrectAnswerIndex() + 1) {
            System.out.println("Correct!");
            score++;
        } else {
            System.out.println("Incorrect!");
        }
    }

    private void displayResult() {
        System.out.println("\nQuiz finished!");
        System.out.println("Your score: " + score + "/" + questions.size());
    }
}

public class Main {
    public static void main(String[] args) {
        // Creating quiz questions
        List<QuizQuestion> quizQuestions = new ArrayList<>();
        List<String> options1 = Arrays.asList("A", "B", "C", "D");
        QuizQuestion question1 = new QuizQuestion("What is 2+2?", options1, 2);
        List<String> options2 = Arrays.asList("Java", "Python", "C++", "Ruby");
        QuizQuestion question2 = new QuizQuestion("Which programming language is Java?", options2, 0);
        // Add more questions...

        quizQuestions.add(question1);
        quizQuestions.add(question2);
        // Add more questions...

        Quiz quiz = new Quiz(quizQuestions);
        quiz.start();
    }
}
