package com.salesforce.tests.fs;

import org.junit.Test;

import java.io.IOException;

/**
 * Place holder for your unit tests
 */
public class YourUnitTest extends BaseTest {
    @Test
    public void testQuit() throws IOException {
        String[] expectedResults = {};
        runTest(expectedResults, "quit");
    }

    @Test
    public void testUnrecognizedCommand() throws IOException {
        String[] expectedResults = {
                "Unrecognized command\n"
        };
        runTest(expectedResults, "sarasa");
    }

    @Test
    public void testCreateDirectory() {
        String[] expectedResults = {
                "/testDirectory\n",
        };
        runTest(expectedResults, "mkdir testDirectory", "ls");
    }

    @Test
    public void testCreateFile() {
        String[] expectedResults = {
                "file.txt\n"
        };
        runTest(expectedResults, "touch file.txt", "ls");
    }

    @Test
    public void testListContents() {
        String[] expectedResults = {
                "/bin\n",
                "project.iml\n"
        };
        runTest(expectedResults, "mkdir bin", "touch project.iml", "ls");
    }

    @Test
    public void testListContentsEmpty() {
        String[] expectedResults = {};
        runTest(expectedResults, "ls");
    }

    @Test
    public void testChangeDirectory() {
        String[] expectedResults = {
                "test.bin\n"
        };
        runTest(expectedResults, "mkdir bin", "cd bin", "touch test.bin", "ls");
    }

    @Test
    public void testCreateFileWithNameTooLong() {
        String[] expectedResults = {
                "File name cannot have more than 100 characters\n"
        };
        runTest(expectedResults, "touch aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "ls");
    }

    @Test
    public void testCreateDirectoryWithNameTooLong() {
        String[] expectedResults = {
                "Directory name cannot have more than 100 characters\n"
        };
        runTest(expectedResults, "mkdir aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", "ls");
    }

    @Test
    public void testCurrentDirectoryWithMultipleLevels() {
        String[] expectedResults = {
                "/root/usr/bin\n"
        };
        runTest(expectedResults, "mkdir usr", "cd usr", "mkdir bin", "cd bin", "pwd", "quit");
    }

    @Test
    public void testCreateDirectoryAlreadyExists() {
        String[] expectedResults = {
                "Directory already exists\n"
        };
        runTest(expectedResults, "mkdir bin", "mkdir bin");
    }

    @Test
    public void testGoToParentDirectory() {
        String[] expectedResults = {
                "/root\n"
        };
        runTest(expectedResults, "mkdir usr", "cd usr", "cd ..", "pwd", "quit");
    }

    @Test
    public void testGoToParentDirectoryFromRoot() {
        String[] expectedResults = {
                "/root\n"
        };
        runTest(expectedResults, "cd ..", "pwd", "quit");
    }

    @Test
    public void testGoToNonexistentDirectory() {
        String[] expectedResults = {
                "Directory not found\n"
        };
        runTest(expectedResults, "cd sarasa");
    }

    @Test
    public void testRecursiveListContents() {
        String[] expectedResults = {
                "/root\n",
                "project.iml\n",
                "/root/bin\n",
                "project.iml\n"
        };
        runTest(expectedResults, "mkdir bin", "touch project.iml", "cd bin", "touch project.iml", "cd ..", "ls -r");
    }
}
