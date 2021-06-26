import org.junit.Test;
import org.junit.After;
import java.lang.reflect.*;
import org.junit.Assert;
import org.junit.Before;
import java.net.Socket;
import java.awt.event.ActionEvent;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import java.io.*;
import java.util.ArrayList;


/**
 * A framework to run public test cases.
 *
 * <p>Purdue University -- CS18000 -- Project 5 -- Fall 2020</p>
 *
 * @author 20 -1 Team
 * @version December 6, 2020
 */
public class RunLocalTestMethods {
    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(TestCase.class);
        if (result.wasSuccessful()) {
            System.out.println("Excellent - Tests ran successfully!");
        } else {
            for (Failure failure : result.getFailures()) {
                System.out.println("Tests Failed ...\n" + failure.toString());
            }
        }
    }

    /**
     * A set of public test cases which tests each method in each class.
     *
     * <p>Purdue University -- CS18000 --- Project 5-- Fall 2020</p>
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

        // 1 ChangePassword tests
        @Test(timeout = 1000)
        public void testChangePassword() {
            Method serverConnectionInitializer;
            Method setLayoutManager;
            Method setLocationAndSize;
            Method addComponentstoPanel;
            Method addActionEvent;
            Method actionPerformed;
            Method testMain; // 7

            // existing
            try {
                serverConnectionInitializer = ChangePassword.class.getDeclaredMethod(
                        "serverConnectionInitializer", Socket.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("serverConnectionInitializer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLayoutManager = ChangePassword.class.getDeclaredMethod("setLayoutManager", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLayoutManager doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLocationAndSize = ChangePassword.class.getDeclaredMethod("setLocationAndSize",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLocationAndSize doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                addComponentstoPanel = ChangePassword.class.getDeclaredMethod("addComponentstoPanel",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("addComponentsToPanel doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                addActionEvent = ChangePassword.class.getDeclaredMethod("addActionEvent", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("addActionEvent doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                actionPerformed = ChangePassword.class.getDeclaredMethod("actionPerformed", ActionEvent.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("actionPerformed doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                testMain = ChangePassword.class.getDeclaredMethod("main", String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("testMain doesn't exist or has incorrect parameters!");
                return;
            }

            // return types
            Assert.assertTrue("Ensure that serverConnectionInitializer is void",
                    serverConnectionInitializer.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLayoutManager is void",
                    setLayoutManager.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLocationAndSize is void",
                    setLocationAndSize.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that addComponentstoPanel is void",
                    addComponentstoPanel.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that addActionEvent is void",
                    addActionEvent.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that actionPerformed is void",
                    actionPerformed.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that main is void",
                    testMain.getReturnType().equals(void.class));

            // modifiers
            Assert.assertTrue("Ensure that serverConnectionInitializer is public!",
                    Modifier.isPublic(serverConnectionInitializer.getModifiers()));
            Assert.assertTrue("Ensure that setLayoutManager is public!",
                    Modifier.isPublic(setLayoutManager.getModifiers()));
            Assert.assertTrue("Ensure that setLocationAndSize is public!",
                    Modifier.isPublic(setLocationAndSize.getModifiers()));
            Assert.assertTrue("Ensure that addComponentstoPanel is public!",
                    Modifier.isPublic(addComponentstoPanel.getModifiers()));
            Assert.assertTrue("Ensure that addActionEvent is public!",
                    Modifier.isPublic(addActionEvent.getModifiers()));
            Assert.assertTrue("Ensure that actionPerformed is public!",
                    Modifier.isPublic(actionPerformed.getModifiers()));
            Assert.assertTrue("Ensure that main is public!",
                    Modifier.isPublic(testMain.getModifiers()));
        }

        // 2 create account test
        @Test(timeout = 1000)
        public void testCreateAccount() {
            // existence
            Method serverConnectionInitializer;
            Method setLayoutManager;
            Method setLocationAndSize;
            Method addComponentsToContainer;
            Method addActionEvent;
            Method actionPerformed;
            Method closingX;
            Method testMain; // 8

            try {
                serverConnectionInitializer = CreateAccount.class.getDeclaredMethod("serverConnectionInitializer",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("serverConnectionInitializer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLayoutManager = CreateAccount.class.getDeclaredMethod("setLayoutManager", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLayoutManager doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLocationAndSize = CreateAccount.class.getDeclaredMethod("setLocationAndSize",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLocationAndSize doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                addComponentsToContainer = CreateAccount.class.getDeclaredMethod("addComponentsToContainer",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("addComponentsToContainer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                addActionEvent = CreateAccount.class.getDeclaredMethod("addActionEvent", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("addActionEvent doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                actionPerformed = CreateAccount.class.getDeclaredMethod("actionPerformed", ActionEvent.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("actionPerformed doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                testMain = CreateAccount.class.getDeclaredMethod("main", String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("testMain doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                closingX = CreateAccount.class.getDeclaredMethod("closingX", CreateAccount.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("closingX doesn't exist or has incorrect parameters!");
                return;
            }

            // return types
            Assert.assertTrue("Ensure that serverConnectionInitializer is void",
                    serverConnectionInitializer.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLayoutManager is void",
                    setLayoutManager.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLocationAndSize is void",
                    setLocationAndSize.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that addComponentsToContainer is void",
                    addComponentsToContainer.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that addActionEvent is void",
                    addActionEvent.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that actionPerformed is void",
                    actionPerformed.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that closingX is void",
                    closingX.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that main is void",
                    testMain.getReturnType().equals(void.class));

            // modifiers
            Assert.assertTrue("Ensure that serverConnectionInitializer is public!",
                    Modifier.isPublic(serverConnectionInitializer.getModifiers()));
            Assert.assertTrue("Ensure that setLayoutManager is public!",
                    Modifier.isPublic(setLayoutManager.getModifiers()));
            Assert.assertTrue("Ensure that setLocationAndSize is public!",
                    Modifier.isPublic(setLocationAndSize.getModifiers()));
            Assert.assertTrue("Ensure that addComponentsToContainer is public!",
                    Modifier.isPublic(addComponentsToContainer.getModifiers()));
            Assert.assertTrue("Ensure that addActionEvent is public!",
                    Modifier.isPublic(addActionEvent.getModifiers()));
            Assert.assertTrue("Ensure that actionPerformed is public!",
                    Modifier.isPublic(actionPerformed.getModifiers()));
            Assert.assertTrue("Ensure that closingX is public!",
                    Modifier.isPublic(closingX.getModifiers()));
            Assert.assertTrue("Ensure that main is public!",
                    Modifier.isPublic(testMain.getModifiers()));
        }

        // 3 edit profile tests
        @Test(timeout = 1000)
        public void testEditProfile() {
            Method serverConnectionInitializer;
            Method setLayoutManager;
            Method setLocationAndSize;
            Method addComponentsToContainer;
            Method addActionEvent;
            Method actionPerformed;
            Method testMain; // 7

            // existence
            try {
                serverConnectionInitializer = EditProfile.class.getDeclaredMethod("serverConnectionInitializer",
                        Socket.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("serverConnectionInitializer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLayoutManager = EditProfile.class.getDeclaredMethod("setLayoutManager", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLayoutManager doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLocationAndSize = EditProfile.class.getDeclaredMethod("setLocationAndSize", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLocationAndSize doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                addComponentsToContainer = EditProfile.class.getDeclaredMethod("addComponentsToContainer",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("addComponentsToContainer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                addActionEvent = EditProfile.class.getDeclaredMethod("addActionEvent", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("addActionEvent doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                actionPerformed = EditProfile.class.getDeclaredMethod("actionPerformed", ActionEvent.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("actionPerformed doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                testMain = EditProfile.class.getDeclaredMethod("main", String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("testMain doesn't exist or has incorrect parameters!");
                return;
            }

            // return types
            Assert.assertTrue("Ensure that serverConnectionInitializer is void",
                    serverConnectionInitializer.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLayoutManager is void",
                    setLayoutManager.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLocationAndSize is void",
                    setLocationAndSize.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that addComponentsToContainer is void",
                    addComponentsToContainer.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that addActionEvent is void",
                    addActionEvent.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that actionPerformed is void",
                    actionPerformed.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that main is void",
                    testMain.getReturnType().equals(void.class));

            // modifiers
            Assert.assertTrue("Ensure that serverConnectionInitializer is public!",
                    Modifier.isPublic(serverConnectionInitializer.getModifiers()));
            Assert.assertTrue("Ensure that setLayoutManager is public!",
                    Modifier.isPublic(setLayoutManager.getModifiers()));
            Assert.assertTrue("Ensure that setLocationAndSize is public!",
                    Modifier.isPublic(setLocationAndSize.getModifiers()));
            Assert.assertTrue("Ensure that addComponentsToContainer is public!",
                    Modifier.isPublic(addComponentsToContainer.getModifiers()));
            Assert.assertTrue("Ensure that addActionEvent is public!",
                    Modifier.isPublic(addActionEvent.getModifiers()));
            Assert.assertTrue("Ensure that actionPerformed is public!",
                    Modifier.isPublic(actionPerformed.getModifiers()));
            Assert.assertTrue("Ensure that main is public!",
                    Modifier.isPublic(testMain.getModifiers()));

        }

        // 4 Find Friends test
        @Test(timeout = 1000)
        public void testFindFriends() {
            Method serverConnectionInitializer;
            Method loadFriendsToComboBox;
            Method setLayoutManager;
            Method setLocationAndSize;
            Method addComponentsToContainer;
            Method addActionEvent;
            Method checkOnlineS;
            Method comboBoxListener;
            Method actionPerformed;
            Method testMain;
            Method checkStatus; // 12


            // existence
            try {
                serverConnectionInitializer = FindFriends.class.getDeclaredMethod("serverConnectionInitializer",
                        Socket.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("serverConnectionInitializer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLayoutManager = FindFriends.class.getDeclaredMethod("setLayoutManager", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLayoutManager doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLocationAndSize = FindFriends.class.getDeclaredMethod("setLocationAndSize",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLocationAndSize doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                addComponentsToContainer = FindFriends.class.getDeclaredMethod("addComponentsToContainer",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("addComponentsToContainer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                addActionEvent = FindFriends.class.getDeclaredMethod("addActionEvent", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("addActionEvent doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                checkOnlineS = FindFriends.class.getDeclaredMethod("checkOnlineS", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("checkOnlineS doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                actionPerformed = FindFriends.class.getDeclaredMethod("actionPerformed", ActionEvent.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("actionPerformed doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                testMain = FindFriends.class.getDeclaredMethod("main", String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("testMain doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                checkStatus = FindFriends.class.getDeclaredMethod("checkStatus", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("checkStatus doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                loadFriendsToComboBox = FindFriends.class.getDeclaredMethod("loadFriendsToComboBox",
                        Socket.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("loadFriendsToComboBox doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                comboBoxListener = FindFriends.class.getDeclaredMethod("comboBoxListener", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("comboBoxListener doesn't exist or has incorrect parameters!");
                return;
            }

            // return type
            Assert.assertTrue("Ensure that serverConnectionInitializer is void",
                    serverConnectionInitializer.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLayoutManager is void",
                    setLayoutManager.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLocationAndSize is void",
                    setLocationAndSize.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that addComponentsToContainer is void",
                    addComponentsToContainer.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that addActionEvent is void",
                    addActionEvent.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that checkOnlineS is void",
                    checkOnlineS.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that actionPerformed is void",
                    actionPerformed.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that main is void",
                    testMain.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that checkStatus is void",
                    checkStatus.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that loadFriendsToComboBox is void",
                    loadFriendsToComboBox.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that comboBoxListener is void",
                    comboBoxListener.getReturnType().equals(void.class));

            // modifiers
            Assert.assertTrue("Ensure that serverConnectionInitializer is public!",
                    Modifier.isPublic(serverConnectionInitializer.getModifiers()));
            Assert.assertTrue("Ensure that setLayoutManager is public!",
                    Modifier.isPublic(setLayoutManager.getModifiers()));
            Assert.assertTrue("Ensure that setLocationAndSize is public!",
                    Modifier.isPublic(setLocationAndSize.getModifiers()));
            Assert.assertTrue("Ensure that addComponentsToContainer is public!",
                    Modifier.isPublic(addComponentsToContainer.getModifiers()));
            Assert.assertTrue("Ensure that addActionEvent is public!",
                    Modifier.isPublic(addActionEvent.getModifiers()));
            Assert.assertTrue("Ensure that checkOnlineS is public!",
                    Modifier.isPublic(checkOnlineS.getModifiers()));
            Assert.assertTrue("Ensure that actionPerformed is public!",
                    Modifier.isPublic(actionPerformed.getModifiers()));
            Assert.assertTrue("Ensure that main is public!",
                    Modifier.isPublic(testMain.getModifiers()));
            Assert.assertTrue("Ensure that checkStatus is public!",
                    Modifier.isPublic(checkStatus.getModifiers()));
            Assert.assertTrue("Ensure that loadFriendsToComboBox is public!",
                    Modifier.isPublic(loadFriendsToComboBox.getModifiers()));
            Assert.assertTrue("Ensure that comboBoxListener is public!",
                    Modifier.isPublic(comboBoxListener.getModifiers()));

        }

        // 5 friend list test
        @Test(timeout = 1000)
        public void testFriendList() {
            Method display;
            Method loadFriends;
            Method closingX;
            Method serverConnectionInitializer;
            Method testMain; // 5

            // existence
            try {
                display = FriendList.class.getDeclaredMethod("display", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("display doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                loadFriends = FriendList.class.getDeclaredMethod("loadFriends", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("loadFriends doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                closingX = FriendList.class.getDeclaredMethod("closingX", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("closingX doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                serverConnectionInitializer = FriendList.class.getDeclaredMethod("serverConnectionInitializer",
                        Socket.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("serverConnectionInitializer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                testMain = FriendList.class.getDeclaredMethod("main", String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("main doesn't exist or has incorrect parameters!");
                return;
            }

            // return type
            Assert.assertTrue("Ensure that display is void",
                    display.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that loadFriends is void",
                    loadFriends.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that closingX is void",
                    closingX.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that serverConnectionInitializer is void",
                    serverConnectionInitializer.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that main is void",
                    testMain.getReturnType().equals(void.class));

            // modifiers
            Assert.assertTrue("Ensure that display is private!",
                    Modifier.isPrivate(display.getModifiers()));
            Assert.assertTrue("Ensure that loadFriends is public!",
                    Modifier.isPublic(loadFriends.getModifiers()));
            Assert.assertTrue("Ensure that closingX is public!",
                    Modifier.isPublic(closingX.getModifiers()));
            Assert.assertTrue("Ensure that serverConnectionInitializer is public!",
                    Modifier.isPublic(serverConnectionInitializer.getModifiers()));
            Assert.assertTrue("Ensure that main is public!",
                    Modifier.isPublic(testMain.getModifiers()));

        }

        // 6 friend request test
        @Test(timeout = 1000)
        public void testFriendRequest() {
            Method getUserFrom;
            Method getUserTo;
            Method getStatus;
            Method getAcceptOrReject;
            Method setStatus;
            Method accept;
            Method reject; // 7

            //existence
            try {
                getUserFrom = FriendRequest.class.getDeclaredMethod("getUserFrom", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getUserFrom doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                getUserTo = FriendRequest.class.getDeclaredMethod("getUserTo", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getUserTo doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                getStatus = FriendRequest.class.getDeclaredMethod("getStatus", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getStatus doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                getAcceptOrReject = FriendRequest.class.getDeclaredMethod("getAcceptOrReject",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getAcceptOrReject doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setStatus = FriendRequest.class.getDeclaredMethod("setStatus", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("setStatus doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                accept = FriendRequest.class.getDeclaredMethod("accept", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("accept doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                reject = FriendRequest.class.getDeclaredMethod("reject", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("reject doesn't exist or has incorrect parameters!");
                return;
            }

            // return type
            Assert.assertTrue("Ensure that getUserFrom has return type User",
                    getUserFrom.getReturnType().equals(User.class));
            Assert.assertTrue("Ensure that getUserTo has return type User",
                    getUserTo.getReturnType().equals(User.class));
            Assert.assertTrue("Ensure that getStatus has return type String",
                    getStatus.getReturnType().equals(String.class));
            Assert.assertTrue("Ensure that getAcceptOrReject has return type int",
                    getAcceptOrReject.getReturnType().equals(int.class));
            Assert.assertTrue("Ensure that setStatus is void",
                    setStatus.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that accept is void",
                    accept.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that reject is void",
                    reject.getReturnType().equals(void.class));


            // modifier
            Assert.assertTrue("Ensure that getUserFrom is public!",
                    Modifier.isPublic(getUserFrom.getModifiers()));
            Assert.assertTrue("Ensure that getUserTo is public!",
                    Modifier.isPublic(getUserTo.getModifiers()));
            Assert.assertTrue("Ensure that getStatus is public!",
                    Modifier.isPublic(getStatus.getModifiers()));
            Assert.assertTrue("Ensure that getAcceptOrReject is public!",
                    Modifier.isPublic(getAcceptOrReject.getModifiers()));
            Assert.assertTrue("Ensure that setStatus is public!",
                    Modifier.isPublic(setStatus.getModifiers()));
            Assert.assertTrue("Ensure that accept is public!",
                    Modifier.isPublic(accept.getModifiers()));
            Assert.assertTrue("Ensure that reject is public!",
                    Modifier.isPublic(reject.getModifiers()));

        }

        // 7 friend requests test
        @Test(timeout = 1000)
        public void testFriendRequests() {
            Method display;
            Method testMain;
            Method serverConnectionInitializer;
            Method closingX;
            Method actionPerformed; // 5

            // existence
            try {
                display = FriendRequests.class.getDeclaredMethod("display", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("display doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                testMain = FriendRequests.class.getDeclaredMethod("main", String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("testMain doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                serverConnectionInitializer = FriendRequests.class.getDeclaredMethod(
                        "serverConnectionInitializer", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("serverConnectionInitializer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                closingX = FriendRequests.class.getDeclaredMethod("closingX", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("closingX doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                actionPerformed = FriendRequests.class.getDeclaredMethod("actionPerformed", ActionEvent.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("actionPerformed doesn't exist or has incorrect parameters!");
                return;
            }


            // return type
            Assert.assertTrue("Ensure that display is void",
                    display.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that main is void",
                    testMain.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that serverConnectionInitializer is void",
                    serverConnectionInitializer.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that closingX is void",
                    closingX.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that actionPerformed is void",
                    actionPerformed.getReturnType().equals(void.class));

            // modifier
            Assert.assertTrue("Ensure that display is private!",
                    Modifier.isPrivate(display.getModifiers()));
            Assert.assertTrue("Ensure that main is public!",
                    Modifier.isPublic(testMain.getModifiers()));
            Assert.assertTrue("Ensure that serverConnectionInitializer is public!",
                    Modifier.isPublic(serverConnectionInitializer.getModifiers()));
            Assert.assertTrue("Ensure that closingX is public!",
                    Modifier.isPublic(closingX.getModifiers()));
            Assert.assertTrue("Ensure that actionPerformed is public!",
                    Modifier.isPublic(actionPerformed.getModifiers()));
        }

        // 8 homepage tests
        @Test(timeout = 1000)
        public void testHomepage() {
            Method setUserFields;
            Method serverConnectionInitializer;
            Method setLayoutManager;
            Method setLocationAndSize;
            Method addComponentsToContainer;
            Method addActionEvent;
            Method actionPerformed;
            Method closingX;
            Method testMain; // 9

            // existence
            try {
                setUserFields = Homepage.class.getDeclaredMethod("setUserFields", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setUserFields doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                serverConnectionInitializer = Homepage.class.getDeclaredMethod("serverConnectionInitializer",
                        Socket.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("serverConnectionInitializer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLayoutManager = Homepage.class.getDeclaredMethod("setLayoutManager", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLayoutManager doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLocationAndSize = Homepage.class.getDeclaredMethod("setLocationAndSize", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLocationAndSize doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                addComponentsToContainer = Homepage.class.getDeclaredMethod("addComponentsToContainer",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("addComponentsToContainer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                testMain = Homepage.class.getDeclaredMethod("main", String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("testMain doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                addActionEvent = Homepage.class.getDeclaredMethod("addActionEvent", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("addActionEvent doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                closingX = Homepage.class.getDeclaredMethod("closingX", Homepage.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("closingX doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                actionPerformed = Homepage.class.getDeclaredMethod("actionPerformed", ActionEvent.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("actionPerformed doesn't exist or has incorrect parameters!");
                return;
            }

            // return types
            Assert.assertTrue("Ensure that setUserFields is void",
                    setUserFields.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that main is void",
                    testMain.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that serverConnectionInitializer is void",
                    serverConnectionInitializer.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that closingX is void",
                    closingX.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that actionPerformed is void",
                    actionPerformed.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLayoutManager is void",
                    setLayoutManager.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLocationAndSize is void",
                    setLocationAndSize.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that addComponentsToContainer is void",
                    addComponentsToContainer.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that addActionEvent is void",
                    addActionEvent.getReturnType().equals(void.class));

            // modifiers
            Assert.assertTrue("Ensure that setUserFields is public!",
                    Modifier.isPublic(setUserFields.getModifiers()));
            Assert.assertTrue("Ensure that main is public!",
                    Modifier.isPublic(testMain.getModifiers()));
            Assert.assertTrue("Ensure that serverConnectionInitializer is public!",
                    Modifier.isPublic(serverConnectionInitializer.getModifiers()));
            Assert.assertTrue("Ensure that closingX is public!",
                    Modifier.isPublic(closingX.getModifiers()));
            Assert.assertTrue("Ensure that actionPerformed is public!",
                    Modifier.isPublic(actionPerformed.getModifiers()));
            Assert.assertTrue("Ensure that setLayoutManager is public!",
                    Modifier.isPublic(setLayoutManager.getModifiers()));
            Assert.assertTrue("Ensure that setLocationAndSize is public!",
                    Modifier.isPublic(setLocationAndSize.getModifiers()));
            Assert.assertTrue("Ensure that addComponentsToContainer is public!",
                    Modifier.isPublic(addComponentsToContainer.getModifiers()));
            Assert.assertTrue("Ensure that addActionEvent is public!",
                    Modifier.isPublic(addActionEvent.getModifiers()));
        }

        // 9 login tests
        @Test(timeout = 1000)
        public void testLogin() {
            Method checkCredentials;
            Method deleteAccount;
            Method listAllUsers;

            // existence
            try {
                checkCredentials = Login.class.getDeclaredMethod("checkCredentials",
                        String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("checkCredentials doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                deleteAccount = Login.class.getDeclaredMethod("deleteAccount", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("deleteAccount doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                listAllUsers = Login.class.getDeclaredMethod("listAllUsers", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("listAllUsers doesn't exist or has incorrect parameters!");
                return;
            }

            // return type
            Assert.assertTrue("Ensure that checkCredentials has return type boolean",
                    checkCredentials.getReturnType().equals(boolean.class));
            Assert.assertTrue("Ensure that deleteAccount has return type boolean",
                    deleteAccount.getReturnType().equals(boolean.class));
            Assert.assertTrue("Ensure that listAllUsers has return type ArrayList",
                    listAllUsers.getReturnType().equals(ArrayList.class));

            // modifiers
            Assert.assertTrue("Ensure that checkCredentials is public!",
                    Modifier.isPublic(checkCredentials.getModifiers()));
            Assert.assertTrue("Ensure that deleteAccount is public!",
                    Modifier.isPublic(deleteAccount.getModifiers()));
            Assert.assertTrue("Ensure that listAllUsers is public!",
                    Modifier.isPublic(listAllUsers.getModifiers()));
        }

        // 10 login gui tests
        @Test(timeout = 1000)
        public void testLoginGUI() {
            Method serverConnectionInitializer;
            Method setLayoutManager;
            Method setLocationAndSize;
            Method addComponentsToContainer;
            Method addActionEvent;
            Method actionPerformed;
            Method testMain; // 7

            // existence
            try {
                serverConnectionInitializer = LoginGUI.class.getDeclaredMethod("serverConnectionInitializer",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("serverConnectionInitializer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLayoutManager = LoginGUI.class.getDeclaredMethod("setLayoutManager", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLayoutManager doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLocationAndSize = LoginGUI.class.getDeclaredMethod("setLocationAndSize", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLocationAndSize doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                addComponentsToContainer = LoginGUI.class.getDeclaredMethod("addComponentsToContainer",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("addComponentsToContainer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                testMain = LoginGUI.class.getDeclaredMethod("main", String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("testMain doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                addActionEvent = LoginGUI.class.getDeclaredMethod("addActionEvent", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("addActionEvent doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                actionPerformed = LoginGUI.class.getDeclaredMethod("actionPerformed", ActionEvent.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("actionPerformed doesn't exist or has incorrect parameters!");
                return;
            }

            // return type
            Assert.assertTrue("Ensure that main is void",
                    testMain.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that serverConnectionInitializer is void",
                    serverConnectionInitializer.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that actionPerformed is void",
                    actionPerformed.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLayoutManager is void",
                    setLayoutManager.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLocationAndSize is void",
                    setLocationAndSize.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that addComponentsToContainer is void",
                    addComponentsToContainer.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that addActionEvent is void",
                    addActionEvent.getReturnType().equals(void.class));

            // modifiers
            Assert.assertTrue("Ensure that main is public!",
                    Modifier.isPublic(testMain.getModifiers()));
            Assert.assertTrue("Ensure that serverConnectionInitializer is public!",
                    Modifier.isPublic(serverConnectionInitializer.getModifiers()));
            Assert.assertTrue("Ensure that actionPerformed is public!",
                    Modifier.isPublic(actionPerformed.getModifiers()));
            Assert.assertTrue("Ensure that setLayoutManager is public!",
                    Modifier.isPublic(setLayoutManager.getModifiers()));
            Assert.assertTrue("Ensure that setLocationAndSize is public!",
                    Modifier.isPublic(setLocationAndSize.getModifiers()));
            Assert.assertTrue("Ensure that addComponentsToContainer is public!",
                    Modifier.isPublic(addComponentsToContainer.getModifiers()));
            Assert.assertTrue("Ensure that addActionEvent is public!",
                    Modifier.isPublic(addActionEvent.getModifiers()));

        }

        // 11 server tests
        @Test(timeout = 1000)
        public void testServer() {
            Method testMain;

            // existence
            try {
                testMain = Server.class.getDeclaredMethod("main", String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("testMain doesn't exist or has incorrect parameters!");
                return;
            }

            // return type
            Assert.assertTrue("Ensure that main is void",
                    testMain.getReturnType().equals(void.class));

            // modifier
            Assert.assertTrue("Ensure that main is public!",
                    Modifier.isPublic(testMain.getModifiers()));
        }

        // 12 server initializer tests
        @Test(timeout = 1000)
        public void testServerInitializer() {
            Method getClientList;
            Method setClientList;
            Method getViewFriendListUsers;
            Method setViewFriendListUsers;
            Method run; // 5

            // existence
            try {
                getClientList = ServerInitializer.class.getDeclaredMethod("getClientList", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getClientList doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setClientList = ServerInitializer.class.getDeclaredMethod("setClientList", ArrayList.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("setClientList doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                getViewFriendListUsers = ServerInitializer.class.getDeclaredMethod("getViewFriendListUsers",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getViewFriendListUsers doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setViewFriendListUsers = ServerInitializer.class.getDeclaredMethod("setViewFriendListUsers",
                        ArrayList.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("setViewFriendListUsers doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                run = ServerInitializer.class.getDeclaredMethod("run", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("run doesn't exist or has incorrect parameters!");
                return;
            }

            // return type
            Assert.assertTrue("Ensure that run is void",
                    run.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setClientList is void",
                    setClientList.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setViewFriendListUsers is void",
                    setViewFriendListUsers.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that getClientList has return type ArrayList",
                    getClientList.getReturnType().equals(ArrayList.class));
            Assert.assertTrue("Ensure that getViewFriendListUsers has return type ArrayList",
                    getViewFriendListUsers.getReturnType().equals(ArrayList.class));



            // modifier
            Assert.assertTrue("Ensure that getClientList is public!",
                    Modifier.isPublic(getClientList.getModifiers()));
            Assert.assertTrue("Ensure that setClientList is public!",
                    Modifier.isPublic(setClientList.getModifiers()));
            Assert.assertTrue("Ensure that getViewFriendListUsers is public!",
                    Modifier.isPublic(getViewFriendListUsers.getModifiers()));
            Assert.assertTrue("Ensure that setViewFriendListUsers is public!",
                    Modifier.isPublic(setViewFriendListUsers.getModifiers()));
            Assert.assertTrue("Ensure that run is public!",
                    Modifier.isPublic(run.getModifiers()));
        }

        // 13 server thread tests
        @Test(timeout = 1000)
        public void testServerThread() {
            Method readData;
            Method handleViewOtherUserProfile;
            Method handleViewUserProfile;
            Method readFriendList;
            Method printInfoToFile;
            Method viewAllFriends;
            Method viewMyRequests;
            Method findUser;
            Method checkIfExists;
            Method printLoginMenu;
            Method countPendingRequest;
            Method deleteFriendAndRequests;
            Method send;
            Method getUsername;
            Method setUsername;
            Method run;
            Method handleConnection;
            Method closeFriendList;
            Method checkIfTheUserExists;
            Method handleChangePassword;
            Method handleStartChat;
            Method openChat;
            Method checkOnline;
            Method handleDisappearingMsg;
            Method handleLogin;
            Method handleCreateAccount;
            Method handleDelete;
            Method handleAllUsers;
            Method handleOnlineUsers;
            Method checkOnlineStatus;
            Method quit;
            Method findFriendRequests;
            Method handleProfileCreation;
            Method checkStatus;
            Method handleFriendRequestSending;
            Method handleAddFriendRequest;
            Method handleFriendRequestReceiving;
            Method closeFriendRequestReceiving;
            Method accept;
            Method reject;
            Method rescind;

            // existence
            try {
                readData = ServerThread.class.getDeclaredMethod("readData", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("readData doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                handleViewOtherUserProfile = ServerThread.class.getDeclaredMethod("handleViewOtherUserProfile",
                        PrintWriter.class, String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("handleViewOtherUserProfile doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                handleViewUserProfile = ServerThread.class.getDeclaredMethod("handleViewUserProfile",
                        PrintWriter.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("handleViewUserProfile doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                readFriendList = ServerThread.class.getDeclaredMethod("readFriendList", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("readFriendList doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                printInfoToFile = ServerThread.class.getDeclaredMethod("printInfoToFile", String.class,
                        String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("printInfoToFile doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                viewAllFriends = ServerThread.class.getDeclaredMethod("viewAllFriends", PrintWriter.class,
                        String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("viewAllFriends doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                viewMyRequests = ServerThread.class.getDeclaredMethod("viewMyRequests", PrintWriter.class,
                        String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("viewMyRequests doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                findUser = ServerThread.class.getDeclaredMethod("findUser", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("findUser doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                checkIfExists = ServerThread.class.getDeclaredMethod("checkIfExists", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("checkIfExists doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                printLoginMenu = ServerThread.class.getDeclaredMethod("printLoginMenu", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("printLoginMenu doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                countPendingRequest = ServerThread.class.getDeclaredMethod("countPendingRequest",
                        ArrayList.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("countPendingRequest doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                deleteFriendAndRequests = ServerThread.class.getDeclaredMethod("deleteFriendAndRequests",
                        String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("deleteFriendAndRequests doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                send = ServerThread.class.getDeclaredMethod("send", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("send doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                getUsername = ServerThread.class.getDeclaredMethod("getUsername", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getUsername doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setUsername = ServerThread.class.getDeclaredMethod("setUsername", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("setUsername doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                run = ServerThread.class.getDeclaredMethod("run", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("run doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                handleConnection = ServerThread.class.getDeclaredMethod("handleConnection", Socket.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("handleConnection doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                closeFriendList = ServerThread.class.getDeclaredMethod("closeFriendList", PrintWriter.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("closeFriendList doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                checkIfTheUserExists = ServerThread.class.getDeclaredMethod("checkIfTheUserExists",
                        PrintWriter.class, String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("checkIfTheUserExists doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                handleChangePassword = ServerThread.class.getDeclaredMethod("handleChangePassword",
                        PrintWriter.class, String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("handleChangePassword doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                handleStartChat = ServerThread.class.getDeclaredMethod("handleStartChat", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("handleStartChat doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                openChat = ServerThread.class.getDeclaredMethod("openChat", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("openChat doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                checkOnline = ServerThread.class.getDeclaredMethod("checkOnline", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("checkOnline doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                handleDisappearingMsg = ServerThread.class.getDeclaredMethod("handleDisappearingMsg",
                        String.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("handleDisappearingMsg doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                handleLogin = ServerThread.class.getDeclaredMethod("handleLogin", PrintWriter.class,
                        String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("handleLogin doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                handleCreateAccount = ServerThread.class.getDeclaredMethod("handleCreateAccount",
                        PrintWriter.class, String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("handleCreateAccount doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                handleDelete = ServerThread.class.getDeclaredMethod("handleDelete", PrintWriter.class,
                        String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("handleDelete doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                handleAllUsers = ServerThread.class.getDeclaredMethod("handleAllUsers", PrintWriter.class,
                        String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("handleAllUsers doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                handleOnlineUsers = ServerThread.class.getDeclaredMethod("handleOnlineUsers", PrintWriter.class,
                        String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("handleOnlineUsers doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                checkOnlineStatus = ServerThread.class.getDeclaredMethod("checkOnlineStatus", PrintWriter.class,
                        String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("checkOnlineStatus doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                quit = ServerThread.class.getDeclaredMethod("quit", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("quit doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                findFriendRequests = ServerThread.class.getDeclaredMethod("findFriendRequests", String.class,
                        String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("findFriendRequests doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                handleProfileCreation = ServerThread.class.getDeclaredMethod("handleProfileCreation",
                        PrintWriter.class, BufferedReader.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("handleProfileCreation doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                checkStatus = ServerThread.class.getDeclaredMethod("checkStatus", String.class,
                        BufferedReader.class, PrintWriter.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("checkStatus doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                handleFriendRequestSending = ServerThread.class.getDeclaredMethod("handleFriendRequestSending",
                        PrintWriter.class, String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("handleFriendRequestSending doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                handleAddFriendRequest = ServerThread.class.getDeclaredMethod("handleAddFriendRequest",
                        BufferedReader.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("handleAddFriendRequest doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                handleFriendRequestReceiving = ServerThread.class.getDeclaredMethod(
                        "handleFriendRequestReceiving", PrintWriter.class, BufferedReader.class, String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("handleFriendRequestReceiving doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                closeFriendRequestReceiving = ServerThread.class.getDeclaredMethod("closeFriendRequestReceiving",
                        PrintWriter.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("closeFriendRequestReceiving doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                accept = ServerThread.class.getDeclaredMethod("accept", PrintWriter.class, BufferedReader.class,
                        String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("accept doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                reject = ServerThread.class.getDeclaredMethod("reject", PrintWriter.class, BufferedReader.class,
                        String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("reject doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                rescind = ServerThread.class.getDeclaredMethod("rescind", PrintWriter.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("rescind doesn't exist or has incorrect parameters!");
                return;
            }

            // return type
            Assert.assertTrue("Ensure that readData is void",
                    readData.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that handleViewOtherUserProfile is void",
                    handleViewOtherUserProfile.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that handleViewUserProfile is void",
                    handleViewUserProfile.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that readFriendList is void",
                    readFriendList.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that printInfoToFile is void",
                    printInfoToFile.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that viewAllFriends is void",
                    viewAllFriends.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that viewMyRequests is void",
                    viewMyRequests.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that findUser has return type int",
                    findUser.getReturnType().equals(int.class));
            Assert.assertTrue("Ensure that checkIfExists has return type boolean",
                    checkIfExists.getReturnType().equals(boolean.class));
            Assert.assertTrue("Ensure that printLoginMenu is void",
                    printLoginMenu.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that countPendingRequest has return type int",
                    countPendingRequest.getReturnType().equals(int.class));
            Assert.assertTrue("Ensure that deleteFriendAndRequests is void",
                    deleteFriendAndRequests.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that send is void",
                    send.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that getUsername has return type String",
                    getUsername.getReturnType().equals(String.class));
            Assert.assertTrue("Ensure that setUsername is void",
                    setUsername.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that run is void",
                    run.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that handleConnection is void",
                    handleConnection.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that closeFriendList is void",
                    closeFriendList.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that checkIfTheUserExists is void",
                    checkIfTheUserExists.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that handleChangePassword is void",
                    handleChangePassword.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that handleStartChat is void",
                    handleStartChat.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that openChat is void",
                    openChat.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that checkOnline has return type boolean",
                    checkOnline.getReturnType().equals(boolean.class));
            Assert.assertTrue("Ensure that handleDisappearingMsg is void",
                    handleDisappearingMsg.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that handleLogin is void",
                    handleLogin.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that handleCreateAccount is void",
                    handleCreateAccount.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that handleDelete is void",
                    handleDelete.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that handleAllUsers is void",
                    handleAllUsers.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that handleOnlineUsers is void",
                    handleOnlineUsers.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that checkOnlineStatus is void",
                    checkOnlineStatus.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that quit is void",
                    quit.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that findFriendRequests has return type int",
                    findFriendRequests.getReturnType().equals(int.class));
            Assert.assertTrue("Ensure that handleProfileCreation is void",
                    handleProfileCreation.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that checkStatus is void",
                    checkStatus.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that handleFriendRequestSending is void",
                    handleFriendRequestSending.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that handleAddFriendRequest is void",
                    handleAddFriendRequest.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that handleFriendRequestReceiving is void",
                    handleFriendRequestReceiving.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that closeFriendRequestReceiving is void",
                    closeFriendRequestReceiving.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that accept is void",
                    accept.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that reject is void",
                    reject.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that rescind is void",
                    rescind.getReturnType().equals(void.class));


            // modifier
            Assert.assertTrue("Ensure that readData is public!",
                    Modifier.isPublic(readData.getModifiers()));
            Assert.assertTrue("Ensure that handleViewOtherUserProfile is public!",
                    Modifier.isPublic(handleViewOtherUserProfile.getModifiers()));
            Assert.assertTrue("Ensure that handleViewUserProfile is public!",
                    Modifier.isPublic(handleViewUserProfile.getModifiers()));
            Assert.assertTrue("Ensure that readFriendList is public!",
                    Modifier.isPublic(readFriendList.getModifiers()));
            Assert.assertTrue("Ensure that printInfoToFile is public!",
                    Modifier.isPublic(printInfoToFile.getModifiers()));
            Assert.assertTrue("Ensure that viewAllFriends is public!",
                    Modifier.isPublic(viewAllFriends.getModifiers()));
            Assert.assertTrue("Ensure that viewMyRequests is public!",
                    Modifier.isPublic(viewMyRequests.getModifiers()));
            Assert.assertTrue("Ensure that findUser is public!",
                    Modifier.isPublic(findUser.getModifiers()));
            Assert.assertTrue("Ensure that checkIfExists is public!",
                    Modifier.isPublic(checkIfExists.getModifiers()));
            Assert.assertTrue("Ensure that printLoginMenu is public!",
                    Modifier.isPublic(printLoginMenu.getModifiers()));
            Assert.assertTrue("Ensure that countPendingRequest is public!",
                    Modifier.isPublic(countPendingRequest.getModifiers()));
            Assert.assertTrue("Ensure that deleteFriendAndRequests is public!",
                    Modifier.isPublic(deleteFriendAndRequests.getModifiers()));
            Assert.assertTrue("Ensure that send is private!",
                    Modifier.isPrivate(send.getModifiers()));
            Assert.assertTrue("Ensure that getUsername is public!",
                    Modifier.isPublic(getUsername.getModifiers()));
            Assert.assertTrue("Ensure that setUsername is public!",
                    Modifier.isPublic(setUsername.getModifiers()));
            Assert.assertTrue("Ensure that run is public!",
                    Modifier.isPublic(run.getModifiers()));
            Assert.assertTrue("Ensure that handleConnection is public!",
                    Modifier.isPublic(handleConnection.getModifiers()));
            Assert.assertTrue("Ensure that closeFriendList is public!",
                    Modifier.isPublic(closeFriendList.getModifiers()));
            Assert.assertTrue("Ensure that checkIfTheUserExists is public!",
                    Modifier.isPublic(checkIfTheUserExists.getModifiers()));
            Assert.assertTrue("Ensure that handleChangePassword is private!",
                    Modifier.isPrivate(handleChangePassword.getModifiers()));
            Assert.assertTrue("Ensure that handleStartChat is private!",
                    Modifier.isPrivate(handleStartChat.getModifiers()));
            Assert.assertTrue("Ensure that openChat is public!",
                    Modifier.isPublic(openChat.getModifiers()));
            Assert.assertTrue("Ensure that checkOnline is public!",
                    Modifier.isPublic(checkOnline.getModifiers()));
            Assert.assertTrue("Ensure that handleDisappearingMsg is private!",
                    Modifier.isPrivate(handleDisappearingMsg.getModifiers()));
            Assert.assertTrue("Ensure that handleLogin is public!",
                    Modifier.isPublic(handleLogin.getModifiers()));
            Assert.assertTrue("Ensure that handleCreateAccount is private!",
                    Modifier.isPrivate(handleCreateAccount.getModifiers()));
            Assert.assertTrue("Ensure that handleDelete is public!",
                    Modifier.isPublic(handleDelete.getModifiers()));
            Assert.assertTrue("Ensure that handleAllUsers is public!",
                    Modifier.isPublic(handleAllUsers.getModifiers()));
            Assert.assertTrue("Ensure that handleOnlineUsers is public!",
                    Modifier.isPublic(handleOnlineUsers.getModifiers()));
            Assert.assertTrue("Ensure that checkOnlineStatus is public!",
                    Modifier.isPublic(checkOnlineStatus.getModifiers()));
            Assert.assertTrue("Ensure that quit is public!",
                    Modifier.isPublic(quit.getModifiers()));
            Assert.assertTrue("Ensure that findFriendRequests is public!",
                    Modifier.isPublic(findFriendRequests.getModifiers()));
            Assert.assertTrue("Ensure that handleProfileCreation is private!",
                    Modifier.isPrivate(handleProfileCreation.getModifiers()));
            Assert.assertTrue("Ensure that checkStatus is public!",
                    Modifier.isPublic(checkStatus.getModifiers()));
            Assert.assertTrue("Ensure that handleFriendRequestSending is public!",
                    Modifier.isPublic(handleFriendRequestSending.getModifiers()));
            Assert.assertTrue("Ensure that handleAddFriendRequest is public!",
                    Modifier.isPublic(handleAddFriendRequest.getModifiers()));
            Assert.assertTrue("Ensure that handleFriendRequestReceiving is public!",
                    Modifier.isPublic(handleFriendRequestReceiving.getModifiers()));
            Assert.assertTrue("Ensure that closeFriendRequestReceiving is public!",
                    Modifier.isPublic(closeFriendRequestReceiving.getModifiers()));
            Assert.assertTrue("Ensure that accept is public!",
                    Modifier.isPublic(accept.getModifiers()));
            Assert.assertTrue("Ensure that reject is public!",
                    Modifier.isPublic(reject.getModifiers()));
            Assert.assertTrue("Ensure that rescind is public!",
                    Modifier.isPublic(rescind.getModifiers()));
        }

        // 14 thank you tests DELETE
        @Test(timeout = 1000)
        public void testThankYou() {
            Method testMain;

            // existence
            try {
                testMain = ThankYou.class.getDeclaredMethod("main", String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("testMain doesn't exist or has incorrect parameters!");
                return;
            }

            // return type
            Assert.assertTrue("Ensure that main is void",
                    testMain.getReturnType().equals(void.class));

            // modifier
            Assert.assertTrue("Ensure that main is public!",
                    Modifier.isPublic(testMain.getModifiers()));

        }

        // 15 user tests
        @Test(timeout = 1000)
        public void testUser() {
            Method getContact;
            Method setContact;
            Method getFirstName;
            Method setFirstName;
            Method getLastName;
            Method setLastName;
            Method getEmail;
            Method setEmail;
            Method getHobbies;
            Method setHobbies;
            Method getAboutMe;
            Method setAboutMe;
            Method getUsername;
            Method setUsername;
            Method getPassword;
            Method setPassword;
            Method getFriendList;
            Method setFriendList;
            Method getFriendRequests;
            Method setFriendRequests;
            Method getMessageReq;

            // existence
            try {
                getContact = User.class.getDeclaredMethod("getContact", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getContact doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                getFirstName = User.class.getDeclaredMethod("getFirstName", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getFirstName doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                getLastName = User.class.getDeclaredMethod("getLastName", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getLastName doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                getEmail = User.class.getDeclaredMethod("getEmail", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getEmail doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                getHobbies = User.class.getDeclaredMethod("getHobbies", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getHobbies doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                getAboutMe = User.class.getDeclaredMethod("getAboutMe", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getAboutMe doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                getUsername = User.class.getDeclaredMethod("getUsername", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getUsername doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                getPassword = User.class.getDeclaredMethod("getPassword", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getPassword doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                getFriendList = User.class.getDeclaredMethod("getFriendList", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getFriendList doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                getFriendRequests = User.class.getDeclaredMethod("getFriendRequests", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getFriendRequests doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                getMessageReq = User.class.getDeclaredMethod("getMessageReq", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("getMessageReq doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setContact = User.class.getDeclaredMethod("setContact", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("setContact doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setFirstName = User.class.getDeclaredMethod("setFirstName", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("setFirstName doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLastName = User.class.getDeclaredMethod("setLastName", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLastName doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setEmail = User.class.getDeclaredMethod("setEmail", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("setEmail doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setHobbies = User.class.getDeclaredMethod("setHobbies", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("setHobbies doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setAboutMe = User.class.getDeclaredMethod("setAboutMe", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("setAboutMe doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setUsername = User.class.getDeclaredMethod("setUsername", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("setUsername doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setPassword = User.class.getDeclaredMethod("setPassword", String.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("setPassword doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setFriendList = User.class.getDeclaredMethod("setFriendList", ArrayList.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("setFriendList doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setFriendRequests = User.class.getDeclaredMethod("setFriendRequests", ArrayList.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("setFriendRequests doesn't exist or has incorrect parameters!");
                return;
            }


            // return types
            Assert.assertTrue("Ensure that getContact has return type String",
                    getContact.getReturnType().equals(String.class));
            Assert.assertTrue("Ensure that getFirstName has return type String",
                    getFirstName.getReturnType().equals(String.class));
            Assert.assertTrue("Ensure that getLastName has return type String",
                    getLastName.getReturnType().equals(String.class));
            Assert.assertTrue("Ensure that getEmail has return type String",
                    getEmail.getReturnType().equals(String.class));
            Assert.assertTrue("Ensure that getHobbies has return type String",
                    getHobbies.getReturnType().equals(String.class));
            Assert.assertTrue("Ensure that getAboutMe has return type String",
                    getAboutMe.getReturnType().equals(String.class));
            Assert.assertTrue("Ensure that getUsername has return type String",
                    getUsername.getReturnType().equals(String.class));
            Assert.assertTrue("Ensure that getPassword has return type String",
                    getPassword.getReturnType().equals(String.class));
            Assert.assertTrue("Ensure that getFriendList has return type ArrayList",
                    getFriendList.getReturnType().equals(ArrayList.class));
            Assert.assertTrue("Ensure that getFriendRequests has return type ArrayList",
                    getFriendRequests.getReturnType().equals(ArrayList.class));
            Assert.assertTrue("Ensure that getMessageReq has return type ArrayList",
                    getMessageReq.getReturnType().equals(ArrayList.class));
            Assert.assertTrue("Ensure that setContact is void",
                    setContact.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setFirstName is void",
                    setFirstName.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLastName is void",
                    setLastName.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setEmail is void",
                    setEmail.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setHobbies is void",
                    setHobbies.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setAboutMe is void",
                    setAboutMe.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setUsername is void",
                    setUsername.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setPassword is void",
                    setPassword.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setFriendList is void",
                    setFriendList.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setFriendRequests is void",
                    setFriendRequests.getReturnType().equals(void.class));

            // modifiers
            Assert.assertTrue("Ensure that getContact is public!",
                    Modifier.isPublic(getContact.getModifiers()));
            Assert.assertTrue("Ensure that setContact is public!",
                    Modifier.isPublic(setContact.getModifiers()));
            Assert.assertTrue("Ensure that getFirstName is public!",
                    Modifier.isPublic(getFirstName.getModifiers()));
            Assert.assertTrue("Ensure that setFirstName is public!",
                    Modifier.isPublic(setFirstName.getModifiers()));
            Assert.assertTrue("Ensure that getLastName is public!",
                    Modifier.isPublic(getLastName.getModifiers()));
            Assert.assertTrue("Ensure that setLastName is public!",
                    Modifier.isPublic(setLastName.getModifiers()));
            Assert.assertTrue("Ensure that getEmail is public!",
                    Modifier.isPublic(getEmail.getModifiers()));
            Assert.assertTrue("Ensure that setEmail is public!",
                    Modifier.isPublic(setEmail.getModifiers()));
            Assert.assertTrue("Ensure that getHobbies is public!",
                    Modifier.isPublic(getHobbies.getModifiers()));
            Assert.assertTrue("Ensure that setHobbies is public!",
                    Modifier.isPublic(setHobbies.getModifiers()));
            Assert.assertTrue("Ensure that getAboutMe is public!",
                    Modifier.isPublic(getAboutMe.getModifiers()));
            Assert.assertTrue("Ensure that setAboutMe is public!",
                    Modifier.isPublic(setAboutMe.getModifiers()));
            Assert.assertTrue("Ensure that getUsername is public!",
                    Modifier.isPublic(getUsername.getModifiers()));
            Assert.assertTrue("Ensure that setUsername is public!",
                    Modifier.isPublic(setUsername.getModifiers()));
            Assert.assertTrue("Ensure that getPassword is public!",
                    Modifier.isPublic(getPassword.getModifiers()));
            Assert.assertTrue("Ensure that setPassword is public!",
                    Modifier.isPublic(setPassword.getModifiers()));
            Assert.assertTrue("Ensure that setFriendList is public!",
                    Modifier.isPublic(setFriendList.getModifiers()));
            Assert.assertTrue("Ensure that getFriendList is public!",
                    Modifier.isPublic(getFriendList.getModifiers()));
            Assert.assertTrue("Ensure that setFriendRequests is public!",
                    Modifier.isPublic(setFriendRequests.getModifiers()));
            Assert.assertTrue("Ensure that getFriendRequests is public!",
                    Modifier.isPublic(getFriendRequests.getModifiers()));
            Assert.assertTrue("Ensure that getMessageReq is public!",
                    Modifier.isPublic(getMessageReq.getModifiers()));

        }

        // 16 view profile tests
        @Test(timeout = 1000)
        public void testViewProfile() {
            Method setUserFields;
            Method serverConnectionInitializer;
            Method setLayoutManager;
            Method setLocationAndSize;
            Method addComponentsToContainer;
            Method testMain;

            // existence
            try {
                setUserFields = ViewProfile.class.getDeclaredMethod("setUserFields", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setUserFields doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                serverConnectionInitializer = ViewProfile.class.getDeclaredMethod("serverConnectionInitializer",
                        Socket.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("serverConnectionInitializer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLayoutManager = ViewProfile.class.getDeclaredMethod("setLayoutManager", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLayoutManager doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLocationAndSize = ViewProfile.class.getDeclaredMethod("setLocationAndSize",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLocationAndSize doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                addComponentsToContainer = ViewProfile.class.getDeclaredMethod("addComponentsToContainer",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("addComponentsToContainer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                testMain = ViewProfile.class.getDeclaredMethod("main", String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("testMain doesn't exist or has incorrect parameters!");
                return;
            }

            // return type
            Assert.assertTrue("Ensure that setUserFields is void",
                    setUserFields.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that main is void",
                    testMain.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that serverConnectionInitializer is void",
                    serverConnectionInitializer.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLayoutManager is void",
                    setLayoutManager.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLocationAndSize is void",
                    setLocationAndSize.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that addComponentsToContainer is void",
                    addComponentsToContainer.getReturnType().equals(void.class));

            // modifiers
            Assert.assertTrue("Ensure that setUserFields is public!",
                    Modifier.isPublic(setUserFields.getModifiers()));
            Assert.assertTrue("Ensure that main is public!",
                    Modifier.isPublic(testMain.getModifiers()));
            Assert.assertTrue("Ensure that serverConnectionInitializer is public!",
                    Modifier.isPublic(serverConnectionInitializer.getModifiers()));
            Assert.assertTrue("Ensure that setLayoutManager is public!",
                    Modifier.isPublic(setLayoutManager.getModifiers()));
            Assert.assertTrue("Ensure that setLocationAndSize is public!",
                    Modifier.isPublic(setLocationAndSize.getModifiers()));
            Assert.assertTrue("Ensure that addComponentsToContainer is public!",
                    Modifier.isPublic(addComponentsToContainer.getModifiers()));

        }

        // 17 welcome tests
        @Test(timeout = 1000)
        public void testWelcome() {
            Method setLayoutManager;
            Method setLocationAndSize;
            Method addComponentsToContainer;
            Method addActionEvent;
            Method actionPerformed;
            Method closingX;
            Method testMain; // 7

            // existence
            try {
                setLayoutManager = Welcome.class.getDeclaredMethod("setLayoutManager", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLayoutManager doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                setLocationAndSize = Welcome.class.getDeclaredMethod("setLocationAndSize", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("setLocationAndSize doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                addComponentsToContainer = Welcome.class.getDeclaredMethod("addComponentsToContainer",
                        null);
            } catch (NoSuchMethodException e) {
                Assert.fail("addComponentsToContainer doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                testMain = Welcome.class.getDeclaredMethod("main", String[].class);
            } catch (NoSuchMethodException e) {
                Assert.fail("testMain doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                addActionEvent = Welcome.class.getDeclaredMethod("addActionEvent", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("addActionEvent doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                closingX = Welcome.class.getDeclaredMethod("closingX", null);
            } catch (NoSuchMethodException e) {
                Assert.fail("closingX doesn't exist or has incorrect parameters!");
                return;
            }
            try {
                actionPerformed = Welcome.class.getDeclaredMethod("actionPerformed", ActionEvent.class);
            } catch (NoSuchMethodException e) {
                Assert.fail("actionPerformed doesn't exist or has incorrect parameters!");
                return;
            }

            // return type
            Assert.assertTrue("Ensure that main is void",
                    testMain.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that closingX is void",
                    closingX.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that actionPerformed is void",
                    actionPerformed.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLayoutManager is void",
                    setLayoutManager.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that setLocationAndSize is void",
                    setLocationAndSize.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that addComponentsToContainer is void",
                    addComponentsToContainer.getReturnType().equals(void.class));
            Assert.assertTrue("Ensure that addActionEvent is void",
                    addActionEvent.getReturnType().equals(void.class));

            // modifiers
            Assert.assertTrue("Ensure that main is public!",
                    Modifier.isPublic(testMain.getModifiers()));
            Assert.assertTrue("Ensure that closingX is public!",
                    Modifier.isPublic(closingX.getModifiers()));
            Assert.assertTrue("Ensure that actionPerformed is public!",
                    Modifier.isPublic(actionPerformed.getModifiers()));
            Assert.assertTrue("Ensure that setLayoutManager is public!",
                    Modifier.isPublic(setLayoutManager.getModifiers()));
            Assert.assertTrue("Ensure that setLocationAndSize is public!",
                    Modifier.isPublic(setLocationAndSize.getModifiers()));
            Assert.assertTrue("Ensure that addComponentsToContainer is public!",
                    Modifier.isPublic(addComponentsToContainer.getModifiers()));
            Assert.assertTrue("Ensure that addActionEvent is public!",
                    Modifier.isPublic(addActionEvent.getModifiers()));

        }
    }
}
