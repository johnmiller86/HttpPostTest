package views;

import utils.HttpController;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import javax.swing.*;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

import static utils.Config.URL_LOGIN;

public class Login extends JFrame{
    private JButton signInButton;
    private JButton createAccountButton;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JPanel loginPanel;

    // Frame constructor
    private Login() {
        super("Login");
        setContentPane(loginPanel);
        pack();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        initialize();
        setResizable(false);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
    }

    /**
     * Initializes the button listeners.
     */
    private void initialize() {
        signInButton.addActionListener(evt -> loginButtonActionPerformed());
//        createAccountButton.addActionListener(evt -> createAccountButtonActionPerformed());
    }

    /**
     * Listener for login button.
     */
    private void loginButtonActionPerformed() {

        // Empty username
        if (usernameTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Username cannot be left blank!");
        }

        // Empty Password
        else if (String.valueOf(passwordField.getPassword()).equals("")) {
            JOptionPane.showMessageDialog(this, "Password cannot be left blank!");
        }

        // Logging in
        else{
            ArrayList<NameValuePair> params = new ArrayList<>();
            params.add(new BasicNameValuePair("email", usernameTextField.getText()));
            params.add(new BasicNameValuePair("password", get_SHA_512_SecurePassword(String.valueOf(passwordField.getPassword()))));
            HttpController httpController = new HttpController(params, URL_LOGIN);
            try {
                JSONObject jObj = new JSONObject(httpController.postResponse());
                boolean error = jObj.getBoolean("error");

                // Check for error node in json
                if (!error) {
                    // Set info
                    JSONObject user = jObj.getJSONObject("user");
                    String username = user.getString("username");
                    String unit = user.getString("unit");

                    // Launch main activity
                    JFrame homeTrashAuditFrame = new HomeTrashAuditFrame(username, unit);
                    homeTrashAuditFrame.setVisible(true);
                    setVisible(false);
                    dispose();
                } else {
                    String errorMsg = jObj.getString("error_msg");
                    JOptionPane.showMessageDialog(this, errorMsg);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Listener for account creation button.
     */
    private void createAccountButtonActionPerformed() {
//        CreateAccountFrame frame = new CreateAccountFrame();
//        frame.setVisible(true);
    }

    /**
     * Hashes a password using SHA 512.
     * @param passwordToHash the input password.
     * @return the hashed password.
     */
    private String get_SHA_512_SecurePassword(String passwordToHash){
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            byte[] bytes = md.digest(passwordToHash.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte aByte : bytes) {
                sb.append(Integer.toString((aByte & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        }
        catch (NoSuchAlgorithmException | UnsupportedEncodingException e){
            e.printStackTrace();
        }
        return generatedPassword;
    }

    // Main tester method
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new Login().setVisible(true));
    }
}
