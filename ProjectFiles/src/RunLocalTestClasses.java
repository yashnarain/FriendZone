import org.junit.Test;
import org.junit.After;

import java.lang.reflect.Modifier;

import org.junit.Assert;
import org.junit.Before;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.swing.*;
import java.io.*;
import org.junit.Test;
import org.junit.After;
import java.lang.reflect.Field;
import org.junit.Assert;
import org.junit.Before;
import org.junit.rules.Timeout;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import javax.swing.*;
import java.io.*;
import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import java.lang.reflect.InvocationTargetException;
import java.util.UUID;

import static org.junit.Assert.*;

/**
 * A framework to run public test cases.
 *
 * <p>Purdue University -- CS18000 -- Project 5 -- Fall 2020</p>
 *
 * @author 20 -1 Team
 * @version December 6, 2020
 */
public class RunLocalTestClasses {
    // total 23 classes

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Test ran successfully");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println(failure.toString());
            }
        }
    }

    /**
     * A framework to run public test cases.
     *
     * <p>Purdue University -- CS18000 -- Project 5 -- Fall 2020</p>
     *
     * @author 20 -1 Team
     * @version December 6, 2020
     */
    public static class TestCase {
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

        private String getOutput() {
            return testOut.toString();
        }

        @SuppressWarnings("SameParameterValue")
        private void receiveInput(String str) {
            testIn = new ByteArrayInputStream(str.getBytes());
            System.setIn(testIn);
        }


        @Test(timeout = 1000)
        public void changePasswordClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = ChangePassword.class; //changed

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `ChangePassword` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `ChangePassword` is NOT `abstract`!",
                    Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `ChangePassword` extends `JFrame`!", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `ChangePassword` implements ActionListener!", 1,
                    superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void findFriendsClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = FindFriends.class; //changed

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `FindFriends` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `FindFriends` is NOT `abstract`!", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `FindFriends` extends `JFrame`!", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `FindFriends` implements ActionListener!", 1,
                    superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void friendListClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = FriendList.class; //changed

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `FriendList` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `FriendList` is NOT `abstract`!", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `FriendList` extends `JFrame`!", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `FriendList` implements no interface!", 0,
                    superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void editProfileClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = FindFriends.class; //changed

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `EditProfile` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `EditProfile` is NOT `abstract`!", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `EditProfile` extends `JFrame`!", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `EditProfile` implements ActionListener!", 1,
                    superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void userClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = User.class; //changed

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `User` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `User` is NOT `abstract`!", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `User` extends Object!", Object.class, superclass);
            Assert.assertEquals("Ensure that `User` implements no interface!", 0,
                    superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void createAccountClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;
            clazz = FindFriends.class; //changed

            modifiers = clazz.getModifiers();

            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `CreateAccount` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `CreateAccount` is NOT `abstract`!",
                    Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `CreateAccount` extends `JFrame`!", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `CreateAccount` implements ActionListener!", 1,
                    superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void welcomeClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Welcome.class; //changed

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertFalse("Ensure that `Welcome` is NOT `abstract`!", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `Welcome` extends `JFrame`!", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `Welcome` implements ActionListener!", 1,
                    superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void serverThreadClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = ServerThread.class; //changed

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `ServerThread` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `ServerThread` is NOT `abstract`!", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `ServerThread` extends `Thread`!", Thread.class, superclass);
            Assert.assertEquals("Ensure that `ServerThread` implements no interface!", 0,
                    superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void serverClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Server.class; //changed

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `Server` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `Server` is NOT `abstract`!", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `Server` extends `Thread`!", Thread.class, superclass);
            Assert.assertEquals("Ensure that `Server` implements no interface!", 0,
                    superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void serverInitializerClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = ServerInitializer.class; //changed

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `ServerInitializer` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `ServerInitializer` is NOT `abstract`!",
                    Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `ServerInitializer` extends `Thread`!", Thread.class, superclass);
            Assert.assertEquals("Ensure that `ServerInitializer` implements no interface!", 0,
                    superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void friendRequestClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = FriendRequest.class; //changed

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `FriendRequest` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `FriendRequest` is NOT `abstract`!",
                    Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `FriendRequest` extends `Object`!", Object.class, superclass);
            Assert.assertEquals("Ensure that `FriendRequest` implements 0 interface!", 0,
                    superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void friendRequestsClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = FriendRequests.class; //changed

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();
            Assert.assertTrue("Ensure that `FriendRequests` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `FriendRequests` is NOT `abstract`!",
                    Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `FriendRequests` extends `JFrame`!", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `FriendRequests` implements ActionListener!", 1,
                    superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void homepageClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Homepage.class; //changed

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `Homepage` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `Homepage` is NOT `abstract`!", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `Homepage` extends `JFrame`!", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `Homepage` implements ActionListener!", 1,
                    superinterfaces.length);

        }

        @Test(timeout = 1000)
        public void loginClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = Login.class; //changed

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `Login` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `Login` is NOT `abstract`!", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `Login` extends `Thread`!", Thread.class, superclass);
            Assert.assertEquals("Ensure that `Login` implements 0 interface!", 0,
                    superinterfaces.length);
        }

        @Test(timeout = 1000)
        public void loginGUIClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = LoginGUI.class; //changed

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertFalse("Ensure that `LoginGUI` is NOT `abstract`!", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `LoginGUI` extends `JFrame`!", JFrame.class, superclass);
            Assert.assertEquals("Ensure that `LoginGUI` implements ActionListener!", 1,
                    superinterfaces.length);

        }


        @Test(timeout = 1000)
        public void thankYouClassDeclarationTest() {
            Class<?> clazz;
            int modifiers;
            Class<?> superclass;
            Class<?>[] superinterfaces;

            clazz = ThankYou.class; //changed

            modifiers = clazz.getModifiers();
            superclass = clazz.getSuperclass();

            superinterfaces = clazz.getInterfaces();

            Assert.assertTrue("Ensure that `Server` is `public`!", Modifier.isPublic(modifiers));
            Assert.assertFalse("Ensure that `Server` is NOT `abstract`!", Modifier.isAbstract(modifiers));
            Assert.assertEquals("Ensure that `Server` extends `Object`!", Object.class, superclass);
            Assert.assertEquals("Ensure that `Server` implements no interface!", 0,
                    superinterfaces.length);
        }
    }
}
