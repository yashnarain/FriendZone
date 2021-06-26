import org.junit.Test;
import org.junit.After;

import java.awt.*;
import java.lang.reflect.Field;

import org.junit.Assert;
import org.junit.Before;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.Modifier;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * A framework to run public test cases.
 *
 * <p>Purdue University -- CS18000 -- Project 5 -- Fall 2020</p>
 *
 * @author 20 -1 Team
 * @version December 6, 2020
 */

public class RunLocalTestFields {
    private final PrintStream originalOutput = System.out;
    private final InputStream originalSysin = System.in;

    @SuppressWarnings("FieldCanBeLocal")
    private ByteArrayInputStream testIn;

    @SuppressWarnings("FieldCanBeLocal")
    private ByteArrayOutputStream testOut;

    @Before
    public void outputStart() {
        testOut = new ByteArrayOutputStream();
        System.setOut(new PrintStream(testOut));
    }

    @After
    public void restoreInputAndOutput() {
        System.setIn(originalSysin);
        System.setOut(originalOutput);
    }

    @SuppressWarnings("SameParameterValue")
    private void receiveInput(String str) {
        testIn = new ByteArrayInputStream(str.getBytes());
        System.setIn(testIn);
    }

    //ChangePassword tests
    @Test(timeout = 1000)
    public void changePasswordFieldTest() {
        Field content;

        Field oLabel; // JLabel("Old password");
        Field fLabel;
        Field sLabel;
        Field ojp; //JPasswordField();
        Field njp;
        Field cjp;
        Field passButton;
        Field reader;
        Field writer;

        try {
            content = ChangePassword.class.getDeclaredField("content");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            oLabel = ChangePassword.class.getDeclaredField("oLabel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            fLabel = ChangePassword.class.getDeclaredField("oLabel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            sLabel = ChangePassword.class.getDeclaredField("sLabel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            ojp = ChangePassword.class.getDeclaredField("ojp");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            njp = ChangePassword.class.getDeclaredField("njp");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            cjp = ChangePassword.class.getDeclaredField("cjp");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        try {
            passButton = ChangePassword.class.getDeclaredField("passButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            reader = ChangePassword.class.getDeclaredField("reader");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            writer = ChangePassword.class.getDeclaredField("writer");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        // return types
        Assert.assertTrue("Ensure that `content` is of right type!", content.getType().equals(Container.class));
        Assert.assertTrue("Ensure that `oLabel` is of right type!", oLabel.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `fLabel` is of right type!!", sLabel.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `sLabel` is of right type!!", fLabel.getType().equals(JLabel.class));

        Assert.assertTrue("Ensure that `ojp` is of right type!", ojp.getType().equals(JPasswordField.class));
        Assert.assertTrue("Ensure that `njp` is of right type!", njp.getType().equals(JPasswordField.class));
        Assert.assertTrue("Ensure that `cjp` is of right type!", cjp.getType().equals(JPasswordField.class));

        Assert.assertTrue("Ensure that `passButton` is of right type!",
                passButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `writer` is of right type!",
                reader.getType().equals(BufferedReader.class));
        Assert.assertTrue("Ensure that `reader` is of right type!", writer.getType().equals(PrintWriter.class));

        //access modifier
        Assert.assertTrue("Ensure that `content` is `private`!", Modifier.isPrivate(content.getModifiers()));
        Assert.assertTrue("Ensure that `ojp` is `private`!", Modifier.isPrivate(ojp.getModifiers()));
        Assert.assertTrue("Ensure that `oLabel` is `private`!", Modifier.isPrivate(oLabel.getModifiers()));
        Assert.assertTrue("Ensure that `njp` is `private`!", Modifier.isPrivate(njp.getModifiers()));
        Assert.assertTrue("Ensure that `cjp` is `private`!", Modifier.isPrivate(cjp.getModifiers()));
        Assert.assertTrue("Ensure that `sLabel` is `private`!", Modifier.isPrivate(sLabel.getModifiers()));
        Assert.assertTrue("Ensure that `reader` is `private`!", Modifier.isPrivate(reader.getModifiers()));
        Assert.assertTrue("Ensure that `writer` is `private`!", Modifier.isPrivate(writer.getModifiers()));
        Assert.assertTrue("Ensure that `passButton` is `private`!",
                Modifier.isPrivate(passButton.getModifiers()));
        Assert.assertTrue("Ensure that `fLabel` is `private`!", Modifier.isPrivate(fLabel.getModifiers()));


    }

    @Test(timeout = 1000)
    public void editProfileFieldTest() {

        Field fText;
        Field sText;
        Field uText;

        Field contactInfo;
        Field cText;
        Field hobbies;
        Field hText;
        Field aboutMe;

        Field aText;
        Field saveButton;
        Field passButton;

        Field deleteButton;
        Field reader;
        Field writer;
        Field container;
        Field fLabel;
        Field sLabel;
        Field uLabel;

        try {
            container = EditProfile.class.getDeclaredField("container");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            fLabel = EditProfile.class.getDeclaredField("fLabel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            sLabel = EditProfile.class.getDeclaredField("sLabel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            uLabel = EditProfile.class.getDeclaredField("uLabel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            fText = EditProfile.class.getDeclaredField("fText");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            sText = EditProfile.class.getDeclaredField("sText");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            cText = EditProfile.class.getDeclaredField("cText");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            aText = EditProfile.class.getDeclaredField("aText");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            hText = EditProfile.class.getDeclaredField("hText");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            uText = EditProfile.class.getDeclaredField("uText");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }


        try {
            contactInfo = EditProfile.class.getDeclaredField("contactInfo");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            aboutMe = EditProfile.class.getDeclaredField("aboutMe");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            hobbies = EditProfile.class.getDeclaredField("hobbies");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            passButton = EditProfile.class.getDeclaredField("passButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            deleteButton = EditProfile.class.getDeclaredField("deleteButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            saveButton = EditProfile.class.getDeclaredField("saveButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        try {
            reader = EditProfile.class.getDeclaredField("reader");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            writer = EditProfile.class.getDeclaredField("writer");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        // return types
        Assert.assertTrue("Ensure that `content` is of right type!",
                container.getType().equals(Container.class));
        Assert.assertTrue("Ensure that `fLabel` is of right type!!", sLabel.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `sLabel` is of right type!!", fLabel.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `uLabel` is of right type!!", uLabel.getType().equals(JLabel.class));

        Assert.assertTrue("Ensure that `fText` is of right type!", fText.getType().equals(JTextField.class));
        Assert.assertTrue("Ensure that `sText` is of right type!", sText.getType().equals(JTextField.class));
        Assert.assertTrue("Ensure that `uText` is of right type!", uText.getType().equals(JTextField.class));
        Assert.assertTrue("Ensure that `aText` is of right type!", aText.getType().equals(JTextField.class));
        Assert.assertTrue("Ensure that `hText` is of right type!", hText.getType().equals(JTextField.class));
        Assert.assertTrue("Ensure that `cText` is of right type!", cText.getType().equals(JTextField.class));
        Assert.assertTrue("Ensure that `aboutMe` is of right type!", aboutMe.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `hobbies` is of right type!", hobbies.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `contactInfo` is of right type!",
                contactInfo.getType().equals(JLabel.class));

        Assert.assertTrue("Ensure that `passButton` is of right type!",
                passButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `saveButton` is of right type!",
                saveButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `deleteButton` is of right type!",
                deleteButton.getType().equals(JButton.class));

        Assert.assertTrue("Ensure that `writer` is of right type!",
                reader.getType().equals(BufferedReader.class));
        Assert.assertTrue("Ensure that `reader` is of right type!", writer.getType().equals(PrintWriter.class));

        //access modifiers
        Assert.assertTrue("Ensure that `reader` is `public`!", Modifier.isPublic(reader.getModifiers()));
        Assert.assertTrue("Ensure that `writer` is `public`!", Modifier.isPublic(writer.getModifiers()));


        Assert.assertTrue("Ensure that `container` is `public`!", Modifier.isPublic(container.getModifiers()));
        Assert.assertTrue("Ensure that `fLabel` is `public`!", Modifier.isPublic(fLabel.getModifiers()));
        Assert.assertTrue("Ensure that `sLabel` is `public`!", Modifier.isPublic(sLabel.getModifiers()));
        Assert.assertTrue("Ensure that `uLabel` is `public`!", Modifier.isPublic(uLabel.getModifiers()));

        Assert.assertTrue("Ensure that `fText` is `public`!", Modifier.isPublic(fText.getModifiers()));
        Assert.assertTrue("Ensure that `sText` is `public`!", Modifier.isPublic(sText.getModifiers()));
        Assert.assertTrue("Ensure that `uText` is `public`!", Modifier.isPublic(uText.getModifiers()));
        Assert.assertTrue("Ensure that `aText` is `public`!", Modifier.isPublic(aText.getModifiers()));
        Assert.assertTrue("Ensure that `hText` is `public`!", Modifier.isPublic(hText.getModifiers()));
        Assert.assertTrue("Ensure that `cText` is `public`!", Modifier.isPublic(cText.getModifiers()));
        Assert.assertTrue("Ensure that `aboutMe` is `public`!", Modifier.isPublic(aboutMe.getModifiers()));
        Assert.assertTrue("Ensure that `hobbies` is `public`!", Modifier.isPublic(hobbies.getModifiers()));
        Assert.assertTrue("Ensure that `contactInfo` is `public`!",
                Modifier.isPublic(contactInfo.getModifiers()));

        Assert.assertTrue("Ensure that `passButton` is `public`!",
                Modifier.isPublic(passButton.getModifiers()));
        Assert.assertTrue("Ensure that `saveButton` is `public`!",
                Modifier.isPublic(saveButton.getModifiers()));
        Assert.assertTrue("Ensure that `deleteButton` is `public`!",
                Modifier.isPublic(deleteButton.getModifiers()));

    }

    @Test(timeout = 1000)
    public void createAccountFieldTest() {
        Field container;
        Field userLabel;
        Field firstnameLabel;
        Field lastnameLabel;

        try {
            container = CreateAccount.class.getDeclaredField("container");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            userLabel = CreateAccount.class.getDeclaredField("userLabel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            firstnameLabel = CreateAccount.class.getDeclaredField("firstnameLabel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            lastnameLabel = CreateAccount.class.getDeclaredField("lastnameLabel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        Field userTextField; // = new JTextField();
        Field firstnameField;
        Field lastnameField;
        Field loginButton; // = new JButton("CREATE ACCOUNT");
        Field resetButton; //
        Field exitButton;
        Field backButton;

        try {
            userTextField = CreateAccount.class.getDeclaredField("userTextField");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            firstnameField = CreateAccount.class.getDeclaredField("firstnameField");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            lastnameField = CreateAccount.class.getDeclaredField("lastnameField");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        try {
            loginButton = CreateAccount.class.getDeclaredField("loginButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            resetButton = CreateAccount.class.getDeclaredField("resetButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            exitButton = CreateAccount.class.getDeclaredField("exitButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            backButton = CreateAccount.class.getDeclaredField("backButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        Field passwordLabel;
        Field passwordField;
        Field showPassword;
        Field showPrompt;
        Field frame;
        Field socket;
        Field reader;
        Field writer;

        try {
            passwordLabel = CreateAccount.class.getDeclaredField("passwordLabel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            passwordField = CreateAccount.class.getDeclaredField("passwordField");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            showPassword = CreateAccount.class.getDeclaredField("showPassword");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        try {
            showPrompt = CreateAccount.class.getDeclaredField("showPrompt");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            frame = CreateAccount.class.getDeclaredField("frame");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            socket = CreateAccount.class.getDeclaredField("socket");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            reader = CreateAccount.class.getDeclaredField("reader");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            writer = CreateAccount.class.getDeclaredField("writer");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        // return types
        Assert.assertTrue("Ensure that `container` is of right type!",
                container.getType().equals(Container.class));
        Assert.assertTrue("Ensure that `userLabel` is of right type!",
                userLabel.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `firstnameLabel` is of right type!",
                firstnameLabel.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `lastnameLabel` is of right type!",
                lastnameLabel.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `showPrompt` is of right type!",
                showPrompt.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `passwordLabel` is of right type!",
                passwordLabel.getType().equals(JLabel.class));

        Assert.assertTrue("Ensure that `passwordField` is of right type!",
                passwordField.getType().equals(JPasswordField.class));
        Assert.assertTrue("Ensure that `firstnameField` is of right type!",
                firstnameField.getType().equals(JTextField.class));
        Assert.assertTrue("Ensure that `lastnameField` is of right type!",
                lastnameField.getType().equals(JTextField.class));
        Assert.assertTrue("Ensure that `userTextField` is of right type!",
                userTextField.getType().equals(JTextField.class));

        Assert.assertTrue("Ensure that `showPassword` is of right type!",
                showPassword.getType().equals(JCheckBox.class));
        Assert.assertTrue("Ensure that `socket` is of right type!",
                socket.getType().equals(Socket.class));
        Assert.assertTrue("Ensure that `frame` is of right type!",
                frame.getType().equals(JFrame.class));


        Assert.assertTrue("Ensure that `loginButton` is of right type!",
                loginButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `resetButton` is of right type!",
                resetButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `exitButton` is of right type!",
                exitButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `backButton` is of right type!",
                backButton.getType().equals(JButton.class));

        Assert.assertTrue("Ensure that `writer` is of right type!",
                reader.getType().equals(BufferedReader.class));
        Assert.assertTrue("Ensure that `reader` is of right type!",
                writer.getType().equals(PrintWriter.class));


        //access modifiers
        Assert.assertTrue("Ensure that `container` is private", Modifier.isPrivate(container.getModifiers()));
        Assert.assertTrue("Ensure that `userLabel` is private", Modifier.isPrivate(userLabel.getModifiers()));
        Assert.assertTrue("Ensure that `firstnameLabel` is private",
                Modifier.isPrivate(firstnameLabel.getModifiers()));
        Assert.assertTrue("Ensure that `lastnameLabel` is private",
                Modifier.isPrivate(lastnameLabel.getModifiers()));
        Assert.assertTrue("Ensure that `showPrompt` is private", Modifier.isPrivate(showPrompt.getModifiers()));
        Assert.assertTrue("Ensure that `passwordLabel` is private",
                Modifier.isPrivate(passwordLabel.getModifiers()));

        Assert.assertTrue("Ensure that `passwordField` is private",
                Modifier.isPrivate(passwordField.getModifiers()));
        Assert.assertTrue("Ensure that `firstnameField` is private",
                Modifier.isPrivate(firstnameField.getModifiers()));
        Assert.assertTrue("Ensure that `lastnameField` is private",
                Modifier.isPrivate(lastnameField.getModifiers()));
        Assert.assertTrue("Ensure that `userTextField` is private",
                Modifier.isPrivate(userTextField.getModifiers()));

        Assert.assertTrue("Ensure that `showPassword` is private",
                Modifier.isPrivate(showPassword.getModifiers()));
        Assert.assertTrue("Ensure that `socket` is public", Modifier.isPublic(socket.getModifiers()));
        Assert.assertTrue("Ensure that `frame` is public", Modifier.isPublic(frame.getModifiers()));


        Assert.assertTrue("Ensure that `loginButton` is private",
                Modifier.isPrivate(loginButton.getModifiers()));
        Assert.assertTrue("Ensure that `resetButton` is private",
                Modifier.isPrivate(resetButton.getModifiers()));
        Assert.assertTrue("Ensure that `exitButton` is private", Modifier.isPrivate(exitButton.getModifiers()));
        Assert.assertTrue("Ensure that `backButton` is private", Modifier.isPrivate(backButton.getModifiers()));

        Assert.assertTrue("Ensure that `writer` is public", Modifier.isPublic(writer.getModifiers()));
        Assert.assertTrue("Ensure that `reader` is public", Modifier.isPublic(reader.getModifiers()));

    }

    @Test(timeout = 1000)
    public void findFriendsFieldTest() {
        Field showPrompt;
        Field container;
        Field sendRequestButton;

        Field viewProfileButton;
        Field onlineStatusButton;

        Field username;
        Field comboBox;

        Field showStatus;

        Field reader;
        Field writer;

        Field toDisplayInCombo;
        Field users;

        try {
            showPrompt = FindFriends.class.getDeclaredField("showPrompt");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            container = FindFriends.class.getDeclaredField("container");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            viewProfileButton = FindFriends.class.getDeclaredField("viewProfileButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            sendRequestButton = FindFriends.class.getDeclaredField("viewProfileButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            onlineStatusButton = FindFriends.class.getDeclaredField("viewProfileButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        try {
            username = FindFriends.class.getDeclaredField("username");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            comboBox = FindFriends.class.getDeclaredField("comboBox");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            reader = FindFriends.class.getDeclaredField("reader");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            writer = FindFriends.class.getDeclaredField("writer");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            showStatus = FindFriends.class.getDeclaredField("showStatus");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            users = FindFriends.class.getDeclaredField("users");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            toDisplayInCombo = FindFriends.class.getDeclaredField("toDisplayInCombo");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        // return types
        Assert.assertTrue("Ensure that `showPrompt` is of right type!",
                showPrompt.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `content` is of right type!",
                container.getType().equals(Container.class));
        Assert.assertTrue("Ensure that `showStatus` is of right type!",
                showStatus.getType().equals(JTextArea.class));

        Assert.assertTrue("Ensure that `sendRequestButton` is of right type!",
                sendRequestButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `viewProfileButton` is of right type!",
                viewProfileButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `onlineStatusButton` is of right type!",
                onlineStatusButton.getType().equals(JButton.class));

        Assert.assertTrue("Ensure that `comboBox` is of right type!",
                comboBox.getType().equals(JComboBox.class));
        Assert.assertTrue("Ensure that `username` is of right type!",
                username.getType().equals(String.class));
        Assert.assertTrue("Ensure that `writer` is of right type!",
                reader.getType().equals(BufferedReader.class));

        Assert.assertTrue("Ensure that `reader` is of right type!",
                writer.getType().equals(PrintWriter.class));
        Assert.assertTrue("Ensure that `toDisplayInCombo` is of right type!",
                toDisplayInCombo.getType().equals(String[].class));
        Assert.assertTrue("Ensure that `users` is of right type!",
                users.getType().equals(String[].class));

        //access
        Assert.assertTrue("Ensure that `reader` is `public`!", Modifier.isPublic(reader.getModifiers()));
        Assert.assertTrue("Ensure that `writer` is `public`!", Modifier.isPublic(writer.getModifiers()));
        Assert.assertTrue("Ensure that `comboBox` is `public`!", Modifier.isPublic(comboBox.getModifiers()));

        Assert.assertTrue("Ensure that `username` is `public`!", Modifier.isPublic(username.getModifiers()));
        Assert.assertTrue("Ensure that `toDisplayInCombo` is `public`!",
                Modifier.isPublic(toDisplayInCombo.getModifiers()));
        Assert.assertTrue("Ensure that `users` is `public`!", Modifier.isPublic(users.getModifiers()));

        Assert.assertTrue("Ensure that `sendRequestButton` is `public`!",
                Modifier.isPublic(sendRequestButton.getModifiers()));
        Assert.assertTrue("Ensure that viewProfileButton is `public`!",
                Modifier.isPublic(viewProfileButton.getModifiers()));
        Assert.assertTrue("Ensure that `showPrompt` is `public`!",
                Modifier.isPublic(showPrompt.getModifiers()));

        Assert.assertTrue("Ensure that `showStatus` is `public`!",
                Modifier.isPublic(showStatus.getModifiers()));
        Assert.assertTrue("Ensure that container is `public`!", Modifier.isPublic(container.getModifiers()));
        Assert.assertTrue("Ensure that `onlineStatusButton` is `public`!",
                Modifier.isPublic(onlineStatusButton.getModifiers()));

    }


    @Test(timeout = 1000)
    public void friendRequestFieldTest() {
        Field userFrom;
        Field userTo;
        Field status;
        Field acceptOrReject;

        try {
            acceptOrReject = FriendRequest.class.getDeclaredField("acceptOrReject");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            userFrom = FriendRequest.class.getDeclaredField("userFrom");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            userTo = FriendRequest.class.getDeclaredField("userTo");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            status = FriendRequest.class.getDeclaredField("status");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        // return types
        Assert.assertTrue("Ensure that `acceptOrReject` is of right type!",
                acceptOrReject.getType().equals(int.class));
        Assert.assertTrue("Ensure that `Status` is of right type!", status.getType().equals(String.class));
        Assert.assertTrue("Ensure that `userTo` is of right type!", userTo.getType().equals(User.class));
        Assert.assertTrue("Ensure that `userFrom` is of right type!", userFrom.getType().equals(User.class));

        //access modifiers

        Assert.assertTrue("Ensure that `status is  `private`!", Modifier.isPrivate(status.getModifiers()));
        Assert.assertTrue("Ensure that `userTo` is `private`!", Modifier.isPrivate(userTo.getModifiers()));
        Assert.assertTrue("Ensure that `acceptOrReject` is `private`!",
                Modifier.isPrivate(acceptOrReject.getModifiers()));
        Assert.assertTrue("Ensure that `userFrom` is `private`!", Modifier.isPrivate(userFrom.getModifiers()));
    }

    @Test(timeout = 1000)
    public void loginFieldTest() {
        Field users;
        Field userFilename;
        try {
            users = Login.class.getDeclaredField("users");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            userFilename = Login.class.getDeclaredField("userFilename");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        // return types
        Assert.assertTrue("Ensure that `userFilename` is of right type!",
                userFilename.getType().equals(String.class));
        Assert.assertTrue("Ensure that `users` is of right type!", users.getType().equals(ArrayList.class));

        Assert.assertTrue("Ensure that `userFilename` is `private`!",
                Modifier.isPrivate(userFilename.getModifiers()));
        Assert.assertTrue("Ensure that `users` is `private`!", Modifier.isPrivate(users.getModifiers()));

    }

    @Test(timeout = 1000)
    public void thankYouFieldTest() {
        Field window;
        try {
            window = ThankYou.class.getDeclaredField("window");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        // return types
        Assert.assertTrue("Ensure that `window` is of right type!", window.getType().equals(JWindow.class));
        // access
        Assert.assertTrue("Ensure that `window` is `public`!", Modifier.isPublic(window.getModifiers()));
    }


    @Test(timeout = 1000)
    public void serverInitializerTest() {

        Field port;
        Field clientList;
        try {
            port = ServerInitializer.class.getDeclaredField("port");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            clientList = ServerInitializer.class.getDeclaredField("clientList");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        // return types
        Assert.assertTrue("Ensure that `port` is of right type!", port.getType().equals(int.class));
        Assert.assertTrue("Ensure that `clientList` is of right type!",
                clientList.getType().equals(ArrayList.class));

        //access
        Assert.assertTrue("Ensure that `port` is `public`!", Modifier.isPublic(port.getModifiers()));
        Assert.assertTrue("Ensure that `clientList` is `public`!",
                Modifier.isPublic(clientList.getModifiers()));
    }

    @Test(timeout = 1000)
    public void viewProfileFieldTest() {
        Field fName;
        Field aboutText;
        Field hobbyText;
        Field contactText;

        Field nameLabel;

        Field reader;
        Field writer;
        Field content;


        try {
            content = ViewProfile.class.getDeclaredField("content");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            fName = ViewProfile.class.getDeclaredField("fName");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            nameLabel = ViewProfile.class.getDeclaredField("nameLabel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            aboutText = ViewProfile.class.getDeclaredField("aboutText");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            hobbyText = ViewProfile.class.getDeclaredField("hobbyText");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            contactText = ViewProfile.class.getDeclaredField("contactText");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            reader = CreateAccount.class.getDeclaredField("reader");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            writer = CreateAccount.class.getDeclaredField("writer");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        // return types
        Assert.assertTrue("Ensure that `content` is of right type!", content.getType().equals(Container.class));
        Assert.assertTrue("Ensure that `nameLabel` is of right type!!",
                nameLabel.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `aboutText` is of right type!",
                aboutText.getType().equals(JTextArea.class));

        Assert.assertTrue("Ensure that `hobbyText` is of right type!",
                hobbyText.getType().equals(JTextArea.class));
        Assert.assertTrue("Ensure that `contactText` is of right type!",
                contactText.getType().equals(JTextArea.class));
        Assert.assertTrue("Ensure that `fName` is of right type!", fName.getType().equals(JTextArea.class));

        Assert.assertTrue("Ensure that `writer` is of right type!",
                reader.getType().equals(BufferedReader.class));
        Assert.assertTrue("Ensure that `reader` is of right type!", writer.getType().equals(PrintWriter.class));


        //access modifiers
        Assert.assertTrue("Ensure that `reader` is `public`!", Modifier.isPublic(reader.getModifiers()));
        Assert.assertTrue("Ensure that `writer` is `public`!", Modifier.isPublic(writer.getModifiers()));
        Assert.assertTrue("Ensure that `content` is `public`!", Modifier.isPublic(content.getModifiers()));

        Assert.assertTrue("Ensure that `nameLabel` is `public`!", Modifier.isPublic(nameLabel.getModifiers()));
        Assert.assertTrue("Ensure that `hobbyText` is `public`!", Modifier.isPublic(hobbyText.getModifiers()));
        Assert.assertTrue("Ensure that `fName` is `public`!", Modifier.isPublic(fName.getModifiers()));

        Assert.assertTrue("Ensure that `contactText` is `public`!",
                Modifier.isPublic(contactText.getModifiers()));
        Assert.assertTrue("Ensure that `aboutText` is `public`!", Modifier.isPublic(aboutText.getModifiers()));
    }

    @Test(timeout = 1000)
    public void loginGUIFieldTest() {
        Field container;
        Field userLabel;
        Field userTextField;
        Field loginButton;
        Field resetButton; //
        Field exitButton;
        Field backButton;

        Field passwordLabel;
        Field passwordField;
        Field showPassword;
        Field showPrompt;
        Field frame;

        Field socket;
        Field reader;
        Field writer;

        try {
            container = LoginGUI.class.getDeclaredField("container");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            userLabel = LoginGUI.class.getDeclaredField("userLabel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }


        try {
            userTextField = LoginGUI.class.getDeclaredField("userTextField");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }


        try {
            loginButton = LoginGUI.class.getDeclaredField("loginButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            resetButton = LoginGUI.class.getDeclaredField("resetButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            exitButton = LoginGUI.class.getDeclaredField("exitButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            backButton = LoginGUI.class.getDeclaredField("backButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        try {
            passwordLabel = LoginGUI.class.getDeclaredField("passwordLabel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            passwordField = LoginGUI.class.getDeclaredField("passwordField");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            showPassword = LoginGUI.class.getDeclaredField("showPassword");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        try {
            showPrompt = LoginGUI.class.getDeclaredField("showPrompt");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            frame = LoginGUI.class.getDeclaredField("frame");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            socket = LoginGUI.class.getDeclaredField("socket");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            reader = LoginGUI.class.getDeclaredField("reader");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            writer = LoginGUI.class.getDeclaredField("writer");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        // return types
        Assert.assertTrue("Ensure that `container` is of right type!",
                container.getType().equals(Container.class));
        Assert.assertTrue("Ensure that `userLabel` is of right type!",
                userLabel.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `showPrompt` is of right type!",
                showPrompt.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `passwordLabel` is of right type!",
                passwordLabel.getType().equals(JLabel.class));

        Assert.assertTrue("Ensure that `passwordField` is of right type!",
                passwordField.getType().equals(JPasswordField.class));
        Assert.assertTrue("Ensure that `userTextField` is of right type!",
                userTextField.getType().equals(JTextField.class));

        Assert.assertTrue("Ensure that `showPassword` is of right type!",
                showPassword.getType().equals(JCheckBox.class));
        Assert.assertTrue("Ensure that `socket` is of right type!", socket.getType().equals(Socket.class));
        Assert.assertTrue("Ensure that `frame` is of right type!", frame.getType().equals(JFrame.class));


        Assert.assertTrue("Ensure that `loginButton` is of right type!",
                loginButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `resetButton` is of right type!",
                resetButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `exitButton` is of right type!",
                exitButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `backButton` is of right type!",
                backButton.getType().equals(JButton.class));

        Assert.assertTrue("Ensure that `writer` is of right type!",
                reader.getType().equals(BufferedReader.class));
        Assert.assertTrue("Ensure that `reader` is of right type!",
                writer.getType().equals(PrintWriter.class));

        //access modifiers
        Assert.assertTrue("Ensure that `container` is private", Modifier.isPrivate(container.getModifiers()));
        Assert.assertTrue("Ensure that `userLabel` is private", Modifier.isPrivate(userLabel.getModifiers()));
        Assert.assertTrue("Ensure that `showPrompt` is private", Modifier.isPrivate(showPrompt.getModifiers()));
        Assert.assertTrue("Ensure that `passwordLabel` is private",
                Modifier.isPrivate(passwordLabel.getModifiers()));

        Assert.assertTrue("Ensure that `passwordField` is private",
                Modifier.isPrivate(passwordField.getModifiers()));
        Assert.assertTrue("Ensure that `userTextField` is private",
                Modifier.isPrivate(userTextField.getModifiers()));

        Assert.assertTrue("Ensure that `showPassword` is private",
                Modifier.isPrivate(showPassword.getModifiers()));
        Assert.assertTrue("Ensure that `socket` is public", Modifier.isPublic(socket.getModifiers()));
        Assert.assertTrue("Ensure that `frame` is private", Modifier.isPrivate(frame.getModifiers()));

        Assert.assertTrue("Ensure that `loginButton` is private",
                Modifier.isPrivate(loginButton.getModifiers()));
        Assert.assertTrue("Ensure that `resetButton` is private",
                Modifier.isPrivate(resetButton.getModifiers()));
        Assert.assertTrue("Ensure that `exitButton` is private", Modifier.isPrivate(exitButton.getModifiers()));
        Assert.assertTrue("Ensure that `backButton` is private", Modifier.isPrivate(backButton.getModifiers()));

        Assert.assertTrue("Ensure that `writer` is private", Modifier.isPrivate(writer.getModifiers()));
        Assert.assertTrue("Ensure that `reader` is private", Modifier.isPrivate(reader.getModifiers()));
    }

    @Test(timeout = 1000)
    public void friendRequestsFieldTest() {
        Field accept;
        Field decline;
        Field frame;
        Field reader;
        Field writer;

        try {
            accept = FriendRequests.class.getDeclaredField("accept");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            decline = FriendRequests.class.getDeclaredField("decline");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        try {
            frame = FriendRequests.class.getDeclaredField("frame");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            reader = LoginGUI.class.getDeclaredField("reader");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            writer = LoginGUI.class.getDeclaredField("writer");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        Field friendsTemp;
        Field username;

        Field t1;

        Field listModel;
        Field reclist;
        Field listModel1;
        Field sentlist;

        Field continueRunning;

        try {
            t1 = FriendRequests.class.getDeclaredField("t1");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            listModel = FriendRequests.class.getDeclaredField("listModel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            listModel1 = FriendRequests.class.getDeclaredField("listModel1");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            username = FriendRequests.class.getDeclaredField("username");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            reclist = FriendRequests.class.getDeclaredField("reclist");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            sentlist = FriendRequests.class.getDeclaredField("sentlist");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            continueRunning = FriendRequests.class.getDeclaredField("continueRunning");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            friendsTemp = FriendRequests.class.getDeclaredField("friendsTemp");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }


        // return types
        Assert.assertTrue("Ensure that `t1` is of right type!", t1.getType().equals(Thread.class));
        Assert.assertTrue("Ensure that `frame` is of right type!", frame.getType().equals(JFrame.class));
        Assert.assertTrue("Ensure that `friendstemp` is of right type!",
                friendsTemp.getType().equals(ArrayList.class));

        Assert.assertTrue("Ensure that `continueRunning` is of right type!",
                continueRunning.getType().equals(boolean.class));
        Assert.assertTrue("Ensure that `username` is of right type!", username.getType().equals(String.class));
        Assert.assertTrue("Ensure that `reclist` is of right type!", reclist.getType().equals(JList.class));

        Assert.assertTrue("Ensure that `sentlist` is of right type!", sentlist.getType().equals(JList.class));
        Assert.assertTrue("Ensure that `listModel` is of right type!",
                listModel.getType().equals(DefaultListModel.class));
        Assert.assertTrue("Ensure that `listModel1` is of right type!",
                listModel1.getType().equals(DefaultListModel.class));

        Assert.assertTrue("Ensure that `decline` is of right type!", decline.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `accept` is of right type!", accept.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `writer` is of right type!",
                reader.getType().equals(BufferedReader.class));
        Assert.assertTrue("Ensure that `reader` is of right type!", writer.getType().equals(PrintWriter.class));


        //access modifiers

        Assert.assertTrue("Ensure that `username is  `public`!", Modifier.isPublic(username.getModifiers()));
        Assert.assertTrue("Ensure that `reclist` is `private`!", Modifier.isPrivate(reclist.getModifiers()));
        Assert.assertTrue("Ensure that `accept` is `Public`!", Modifier.isPublic(accept.getModifiers()));
        Assert.assertTrue("Ensure that `friendsTemp` is `Public`!",
                Modifier.isPublic(friendsTemp.getModifiers()));
        Assert.assertTrue("Ensure that `reader` is `Private`!", Modifier.isPrivate(reader.getModifiers()));
        Assert.assertTrue("Ensure that `writer` is `Private`!", Modifier.isPrivate(writer.getModifiers()));
        Assert.assertTrue("Ensure that `t1` is  `public`!", Modifier.isPublic(t1.getModifiers()));
        Assert.assertTrue("Ensure that `list` is `private`!", Modifier.isPrivate(listModel.getModifiers()));
        Assert.assertTrue("Ensure that `listModel` is `private`!",
                Modifier.isPrivate(listModel.getModifiers()));
        Assert.assertTrue("Ensure that `frame` is `public`!", Modifier.isPublic(frame.getModifiers()));
        Assert.assertTrue("Ensure that `listModel1` is `private`!",
                Modifier.isPrivate(listModel1.getModifiers()));
        Assert.assertTrue("Ensure that `continueRunning` is `private`!",
                Modifier.isPrivate(continueRunning.getModifiers()));
        Assert.assertTrue("Ensure that `decline` is `public`!", Modifier.isPublic(decline.getModifiers()));

    }

    @Test(timeout = 1000)
    public void friendListFieldTest() {
        Field t1;
        Field frame;
        Field list;
        Field listModel;
        Field flSocket;
        Field reader;
        Field writer;

        try {
            reader = LoginGUI.class.getDeclaredField("reader");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            writer = LoginGUI.class.getDeclaredField("writer");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            list = FriendList.class.getDeclaredField("list");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            flSocket = FriendList.class.getDeclaredField("flSocket");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            frame = FriendList.class.getDeclaredField("frame");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            listModel = FriendList.class.getDeclaredField("listModel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            t1 = FriendList.class.getDeclaredField("t1");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }


        // return types
        Assert.assertTrue("Ensure that `t1` is of right type!", t1.getType().equals(Thread.class));
        Assert.assertTrue("Ensure that `frame` is of right type!", frame.getType().equals(JFrame.class));
        Assert.assertTrue("Ensure that `listModel` is of right type!",
                listModel.getType().equals(DefaultListModel.class));
        Assert.assertTrue("Ensure that `flSocket` is of right type!", flSocket.getType().equals(Socket.class));
        Assert.assertTrue("Ensure that `list` is of right type!", list.getType().equals(JList.class));
        Assert.assertTrue("Ensure that `writer` is of right type!",
                reader.getType().equals(BufferedReader.class));
        Assert.assertTrue("Ensure that `reader` is of right type!", writer.getType().equals(PrintWriter.class));

        //access modifiers
        Assert.assertTrue("Ensure that `reader` is `private`!", Modifier.isPrivate(reader.getModifiers()));
        Assert.assertTrue("Ensure that `writer` is `private`!", Modifier.isPrivate(writer.getModifiers()));
        Assert.assertTrue("Ensure that `t1` is  `public`!", Modifier.isPublic(t1.getModifiers()));
        Assert.assertTrue("Ensure that `list` is `private`!", Modifier.isPrivate(list.getModifiers()));
        Assert.assertTrue("Ensure that `listModel` is `private`!",
                Modifier.isPrivate(listModel.getModifiers()));
        Assert.assertTrue("Ensure that `frame` is `public`!", Modifier.isPublic(frame.getModifiers()));
        Assert.assertTrue("Ensure that `flSocket` is `public`!", Modifier.isPublic(flSocket.getModifiers()));

    }


    @Test(timeout = 1000)
    public void welcomeFieldTest() {
        Field container;
        Field loginButton;
        Field exitButton;

        Field showPrompt;
        Field frame;

        Field createAccountButton;
        Field selectLabel;
        Field logout;

        try {
            container = Welcome.class.getDeclaredField("container");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            selectLabel = Welcome.class.getDeclaredField("selectLabel");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            logout = Welcome.class.getDeclaredField("logout");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            loginButton = Welcome.class.getDeclaredField("loginButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            createAccountButton = Welcome.class.getDeclaredField("createAccountButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            exitButton = Welcome.class.getDeclaredField("exitButton");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        try {
            showPrompt = Welcome.class.getDeclaredField("showPrompt");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            frame = Welcome.class.getDeclaredField("frame");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        // return types
        Assert.assertTrue("Ensure that `container` is of right type!",
                container.getType().equals(Container.class));
        Assert.assertTrue("Ensure that `selectLabel` is of right type!",
                selectLabel.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `showPrompt` is of right type!",
                showPrompt.getType().equals(JLabel.class));

        Assert.assertTrue("Ensure that `createAccountButton` is of right type!",
                createAccountButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `logout` is of right type!", logout.getType().equals(boolean.class));
        Assert.assertTrue("Ensure that `frame` is of right type!", frame.getType().equals(JFrame.class));

        Assert.assertTrue("Ensure that `loginButton` is of right type!",
                loginButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `exitButton` is of right type!",
                exitButton.getType().equals(JButton.class));

        //ACCESS

        Assert.assertTrue("Ensure that `container` is public", Modifier.isPublic(container.getModifiers()));
        Assert.assertTrue("Ensure that `showPrompt` is public", Modifier.isPublic(showPrompt.getModifiers()));
        Assert.assertTrue("Ensure that `frame` is public", Modifier.isPublic(frame.getModifiers()));

        Assert.assertTrue("Ensure that `createAccountButton` is public",
                Modifier.isPublic(createAccountButton.getModifiers()));
        Assert.assertTrue("Ensure that `selectLabel` is public", Modifier.isPublic(selectLabel.getModifiers()));

        Assert.assertTrue("Ensure that `logout` is Public", Modifier.isPublic(logout.getModifiers()));
        Assert.assertTrue("Ensure that `loginButton` is Public", Modifier.isPublic(loginButton.getModifiers()));
        Assert.assertTrue("Ensure that `exitButton` is Public", Modifier.isPublic(exitButton.getModifiers()));
    }

    @Test(timeout = 1000)
    public void userFieldTest() {

        Field firstName;
        Field lastName;
        Field email;
        Field contact;
        Field hobbies;
        Field aboutMe;
        Field username;
        Field password;
        Field friendList;
        Field friendRequests;
        Field messageReq;


        try {
            firstName = User.class.getDeclaredField("firstName");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            lastName = User.class.getDeclaredField("lastName");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            email = User.class.getDeclaredField("email");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            contact = User.class.getDeclaredField("contact");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            username = User.class.getDeclaredField("username");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            password = User.class.getDeclaredField("password");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            friendList = User.class.getDeclaredField("friendList");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            friendRequests = User.class.getDeclaredField("friendRequests");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            messageReq = User.class.getDeclaredField("messageReq");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            aboutMe = User.class.getDeclaredField("aboutMe");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        try {
            hobbies = User.class.getDeclaredField("hobbies");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }

        // return types
        Assert.assertTrue("Ensure that `firstName` is of right type!",
                firstName.getType().equals(String.class));
        Assert.assertTrue("Ensure that `aboutMe` is of right type!", aboutMe.getType().equals(String.class));
        Assert.assertTrue("Ensure that `hobbies` is of right type!", hobbies.getType().equals(String.class));

        Assert.assertTrue("Ensure that `lastName` is of right type!", lastName.getType().equals(String.class));
        Assert.assertTrue("Ensure that `email` is of right type!", email.getType().equals(String.class));
        Assert.assertTrue("Ensure that `contact` is of right type!", contact.getType().equals(String.class));

        Assert.assertTrue("Ensure that `friendList` is of right type!",
                friendList.getType().equals(ArrayList.class));
        Assert.assertTrue("Ensure that `username` is of right type!", username.getType().equals(String.class));
        Assert.assertTrue("Ensure that `password` is of right type!", password.getType().equals(String.class));

        Assert.assertTrue("Ensure that `messageReq` is of right type!",
                messageReq.getType().equals(ArrayList.class));
        Assert.assertTrue("Ensure that `friendRequests` is of right type!",
                friendRequests.getType().equals(ArrayList.class));


        //access

        Assert.assertTrue("Ensure that `aboutMe` is `private`!", Modifier.isPrivate(aboutMe.getModifiers()));
        Assert.assertTrue("Ensure that `hobbies` is `Private`!", Modifier.isPrivate(hobbies.getModifiers()));
        Assert.assertTrue("Ensure that `contact` is `Private`!", Modifier.isPrivate(contact.getModifiers()));

        Assert.assertTrue("Ensure that `password` is `Private`!", Modifier.isPrivate(password.getModifiers()));
        Assert.assertTrue("Ensure that `username` is `Private`!", Modifier.isPrivate(username.getModifiers()));
        Assert.assertTrue("Ensure that `messageReq` is `Private`!",
                Modifier.isPrivate(messageReq.getModifiers()));

        Assert.assertTrue("Ensure that `lastName` is `Private`!", Modifier.isPrivate(lastName.getModifiers()));
        Assert.assertTrue("Ensure that `friendList` is `Private`!",
                Modifier.isPrivate(friendList.getModifiers()));
        Assert.assertTrue("Ensure that `friendRequests` is `Private`!",
                Modifier.isPrivate(friendRequests.getModifiers()));

        Assert.assertTrue("Ensure that `email` is `Private`!", Modifier.isPrivate(email.getModifiers()));
        Assert.assertTrue("Ensure that `firstname` is `Private`!",
                Modifier.isPrivate(firstName.getModifiers()));
        Assert.assertTrue("Ensure that `lastname` is `Private`!", Modifier.isPrivate(lastName.getModifiers()));


    }

    @Test(timeout = 1000)
    public void homepageFieldTest() {
        Field content;
        Field listButton;
        Field findButton;
        Field editButton ;
        Field reqButton ;
        Field logButton;
        Field deleteButton;
        Field frame;
        Field uname;
        Field reader;
        Field writer;
        Field fName;
        Field nameLabel;
        Field aboutText;
        Field hobbyText;
        Field contactText;
        Field emailText;

        try {
            content = Homepage.class.getDeclaredField("content");
            listButton = Homepage.class.getDeclaredField("listButton");
            findButton = Homepage.class.getDeclaredField("findButton");
            editButton = Homepage.class.getDeclaredField("editButton");
            reqButton = Homepage.class.getDeclaredField("reqButton");
            logButton = Homepage.class.getDeclaredField("logButton");
            deleteButton = Homepage.class.getDeclaredField("deleteButton");
            frame = Homepage.class.getDeclaredField("frame");
            reader = Homepage.class.getDeclaredField("reader");
            writer = Homepage.class.getDeclaredField("writer");
            uname = Homepage.class.getDeclaredField("uname");
            fName = Homepage.class.getDeclaredField("fName");
            nameLabel = Homepage.class.getDeclaredField("nameLabel");
            aboutText = Homepage.class.getDeclaredField("aboutText");
            hobbyText = Homepage.class.getDeclaredField("hobbyText");
            contactText = Homepage.class.getDeclaredField("contactText");
            emailText = Homepage.class.getDeclaredField("emailText");

        } catch (NoSuchFieldException e) {
            Assert.fail("Ensure all fields exist!");
            return;
        }


        Assert.assertTrue("Ensure that `content` is of right type!", content.getType().equals(Container.class));
        Assert.assertTrue("Ensure that `listButton` is of right type!",
                listButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `findButton` is of right type!",
                findButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `frame` is of right type!", frame.getType().equals(JFrame.class));
        Assert.assertTrue("Ensure that `reqButton` is of right type!",
                reqButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `logButton` is of right type!",
                logButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `deleteButton` is of right type!",
                deleteButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `editButton` is of right type!",
                editButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `logButton` is of right type!",
                logButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `deleteButton` is of right type!",
                deleteButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `editButton` is of right type!",
                editButton.getType().equals(JButton.class));
        Assert.assertTrue("Ensure that `writer` is of right type!",
                reader.getType().equals(BufferedReader.class));
        Assert.assertTrue("Ensure that `reader` is of right type!",
                writer.getType().equals(PrintWriter.class));
        Assert.assertTrue("Ensure that `aboutText` is of right type!",
                aboutText.getType().equals(JTextArea.class));
        Assert.assertTrue("Ensure that `hobbyText` is of right type!",
                hobbyText.getType().equals(JTextArea.class));
        Assert.assertTrue("Ensure that `contactText` is of right type!",
                contactText.getType().equals(JTextArea.class));
        Assert.assertTrue("Ensure that `fName` is of right type!",
                fName.getType().equals(JTextArea.class));
        Assert.assertTrue("Ensure that `emailText` is of right type!",
                emailText.getType().equals(JTextArea.class));
        Assert.assertTrue("Ensure that `nameLabel` is of right type!",
                nameLabel.getType().equals(JLabel.class));
        Assert.assertTrue("Ensure that `uname` is of right type!",
                uname.getType().equals(JTextField.class));


        //access modifiers
        Assert.assertTrue("Ensure that `reader` is `public`!", Modifier.isPublic(reader.getModifiers()));
        Assert.assertTrue("Ensure that `writer` is `public`!", Modifier.isPublic(writer.getModifiers()));
        Assert.assertTrue("Ensure that `content` is  `public`!", Modifier.isPublic(content.getModifiers()));
        Assert.assertTrue("Ensure that `listButton` is `public`!",
                Modifier.isPublic(listButton.getModifiers()));
        Assert.assertTrue("Ensure that `findButton` is `public`!",
                Modifier.isPublic(findButton.getModifiers()));
        Assert.assertTrue("Ensure that `frame` is `public`!", Modifier.isPublic(frame.getModifiers()));
        Assert.assertTrue("Ensure that `reqButton` is `public`!", Modifier.isPublic(reqButton.getModifiers()));
        Assert.assertTrue("Ensure that `logButton` is `public`!", Modifier.isPublic(logButton.getModifiers()));
        Assert.assertTrue("Ensure that `deleteButton` is `public`!",
                Modifier.isPublic(deleteButton.getModifiers()));
        Assert.assertTrue("Ensure that `editButton` is `public`!",
                Modifier.isPublic(editButton.getModifiers()));
        Assert.assertTrue("Ensure that `logButton` is `public`!", Modifier.isPublic(logButton.getModifiers()));
        Assert.assertTrue("Ensure that `deleteButton` is `public`!",
                Modifier.isPublic(deleteButton.getModifiers()));
        Assert.assertTrue("Ensure that `editButton` is `public`!",
                Modifier.isPublic(editButton.getModifiers()));
        Assert.assertTrue("Ensure that `aboutText` is `public`!", Modifier.isPublic(aboutText.getModifiers()));
        Assert.assertTrue("Ensure that `hobbyText` is `public`!", Modifier.isPublic(hobbyText.getModifiers()));
        Assert.assertTrue("Ensure that `contactText` is `public`!",
                Modifier.isPublic(contactText.getModifiers()));
        Assert.assertTrue("Ensure that `fName` is `public`!", Modifier.isPublic(fName.getModifiers()));
        Assert.assertTrue("Ensure that `emailText` is `public`!", Modifier.isPublic(emailText.getModifiers()));
        Assert.assertTrue("Ensure that `nameLabel` is `public`!", Modifier.isPublic(nameLabel.getModifiers()));
        Assert.assertTrue("Ensure that `uname` is `public`!", Modifier.isPublic(uname.getModifiers()));
        Assert.assertTrue("Ensure that `deleteButton` is `public`!",
                Modifier.isPublic(deleteButton.getModifiers()));
    }

    @Test(timeout = 1000)
    public void serverThreadFieldTest() {
        Field pw;
        Field bfr;
        Field username;
        Field userIndex;
        Field users;
        Field friendRequests;
        Field firstName;
        Field lastName;
        Field friendList;
        Field myFriends;

        Field clientSocket;
        Field serverInitializer;

        try {

            bfr = ServerThread.class.getDeclaredField("bfr");
            pw = ServerThread.class.getDeclaredField("pw");

            username = ServerThread.class.getDeclaredField("username");
            users = ServerThread.class.getDeclaredField("users");
            friendRequests = ServerThread.class.getDeclaredField("friendRequests");
            firstName = ServerThread.class.getDeclaredField("firstName");
            lastName = ServerThread.class.getDeclaredField("lastName");
            myFriends = ServerThread.class.getDeclaredField("myFriends");
            friendList = ServerThread.class.getDeclaredField("friendList");
            userIndex = ServerThread.class.getDeclaredField("userIndex");

            serverInitializer = ServerThread.class.getDeclaredField("serverInitializer");
            clientSocket = ServerThread.class.getDeclaredField("clientSocket");
        } catch (NoSuchFieldException e) {
            Assert.fail("The field doesn't exist!");
            return;
        }
        // return types

        Assert.assertTrue("Ensure that `writer` is of right type!", bfr.getType().equals(BufferedReader.class));
        Assert.assertTrue("Ensure that `reader` is of right type!", pw.getType().equals(PrintWriter.class));
        Assert.assertTrue("Ensure that `friendRequests` is of right type!",
                friendRequests.getType().equals(List.class));

        Assert.assertTrue("Ensure that `myFriends` is of right type!",
                myFriends.getType().equals(ArrayList.class));
        Assert.assertTrue("Ensure that `firstName` is of right type!", firstName.getType().equals(String.class));
        Assert.assertTrue("Ensure that `lastName` is of right type!", lastName.getType().equals(String.class));

        Assert.assertTrue("Ensure that `username` is of right type!", username.getType().equals(String.class));
        Assert.assertTrue("Ensure that `users` is of right type!", users.getType().equals(java.util.List.class));
        Assert.assertTrue("Ensure that `friendList` is of right type!",
                friendList.getType().equals(ArrayList.class));

        Assert.assertTrue("Ensure that `userIndex` is of right type!", userIndex.getType().equals(int.class));
        Assert.assertTrue("Ensure that `clientSocket` is of right type!",
                clientSocket.getType().equals(Socket.class));
        Assert.assertTrue("Ensure that `serverInitializer` is of right type!",
                serverInitializer.getType().equals(ServerInitializer.class));

        //access

        Assert.assertTrue("Ensure that `bfr` is `private`!", Modifier.isPrivate(bfr.getModifiers()));
        Assert.assertTrue("Ensure that `pw` is `Private`!", Modifier.isPrivate(pw.getModifiers()));
        Assert.assertTrue("Ensure that `serverInitializer` is `Private`!",
                Modifier.isPrivate(serverInitializer.getModifiers()));

        Assert.assertTrue("Ensure that `password` is `Private`!", Modifier.isPrivate(firstName.getModifiers()));
        Assert.assertTrue("Ensure that `username` is `Private`!", Modifier.isPrivate(username.getModifiers()));
        Assert.assertTrue("Ensure that `users` is `Public`!", Modifier.isPublic(users.getModifiers()));

        Assert.assertTrue("Ensure that `clientSocket` is `Private`!",
                Modifier.isPrivate(clientSocket.getModifiers()));
        Assert.assertTrue("Ensure that `friendList` is `Private`!",
                Modifier.isPrivate(friendList.getModifiers()));
        Assert.assertTrue("Ensure that `friendRequests` is `Private`!",
                Modifier.isPrivate(friendRequests.getModifiers()));

        Assert.assertTrue("Ensure that `userIndex` is `Private`!",
                Modifier.isPrivate(userIndex.getModifiers()));
        Assert.assertTrue("Ensure that `myFriends` is `Private`!",
                Modifier.isPrivate(myFriends.getModifiers()));
        Assert.assertTrue("Ensure that `lastname` is `Private`!", Modifier.isPrivate(lastName.getModifiers()));
    }
}
