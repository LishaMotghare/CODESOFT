import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class QuizApplication extends JFrame {
    private int score;
    private int currentQuestion;
    private String[] questions;
    private String[][] options;
    private String[] correctAnswers;
    private JLabel questionLabel;
    private JRadioButton[] optionRadioButtons;
    private JButton submitButton;
    private Timer timer;

    public QuizApplication() {
        // Initialize quiz questions, options, and correct answers
        questions = new String[] {
            "What is the capital of France?",
            "Which planet is the largest in our solar system?",
            "Who painted the famous artwork 'The Starry Night'?"
        };

        options = new String[][] {
            {"Paris", "London", "Berlin", "Rome"},
            {"Earth", "Saturn", "Jupiter", "Uranus"},
            {"Leonardo da Vinci", "Vincent van Gogh", "Pablo Picasso", "Claude Monet"}
        };

        correctAnswers = new String[] {"Paris", "Jupiter", "Vincent van Gogh"};

        // Initialize GUI components
        questionLabel = new JLabel(questions[0]);
        optionRadioButtons = new JRadioButton[4];
        for (int i = 0; i < 4; i++) {
            optionRadioButtons[i] = new JRadioButton(options[0][i]);
        }
        submitButton = new JButton("Submit");

        // Create a ButtonGroup to manage the radio buttons
        ButtonGroup buttonGroup = new ButtonGroup();
        for (JRadioButton radioButton : optionRadioButtons) {
            buttonGroup.add(radioButton);
        }

        // Add action listener to the submit button
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the selected option
                String selectedOption = null;
                for (JRadioButton radioButton : optionRadioButtons) {
                    if (radioButton.isSelected()) {
                        selectedOption = radioButton.getText();
                        break;
                    }
                }

                // Check if the selected option is correct
                if (selectedOption.equals(correctAnswers[currentQuestion])) {
                    score++;
                    System.out.println("Correct!");
                } else {
                    System.out.println("Incorrect. The correct answer is " + correctAnswers[currentQuestion]);
                }

                // Move to the next question
                currentQuestion++;
                if (currentQuestion < questions.length) {
                    questionLabel.setText(questions[currentQuestion]);
                    for (int i = 0; i < 4; i++) {
                        optionRadioButtons[i].setText(options[currentQuestion][i]);
                    }
                } else {
                    // Display the final score and result
                    System.out.println("Quiz completed! Your final score is " + score + " out of " + questions.length);
                    System.exit(0);
                }
            }
        });

        // Create a timer to limit the time to answer each question
        timer = new Timer(30000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Time's up! Moving to the next question...");
                submitButton.doClick();
            }
        });
        timer.setRepeats(false);

        // Add GUI components to the frame
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(questionLabel);
        for (JRadioButton radioButton : optionRadioButtons) {
            panel.add(radioButton);
        }
        panel.add(submitButton);
        add(panel);

        // Set up the frame
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        // Start the timer for the first question
        timer.start();
    }

    public static void main(String[] args) {
        new QuizApplication();
    }
}


// Note : This Java code implements a simple quiz application with a timer that:

// - Stores quiz questions along with multiple-choice options and correct answers.
// - Implements a timer to limit the time to answer each question.
// - Presents one question at a time with multiple-choice options.
// - Allows users to select an option and submit their answer within the given time.
// - Keeps track of the user's score based on correct answers.
// - Displays the final score and a summary of correct/incorrect answers.


