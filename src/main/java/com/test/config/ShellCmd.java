package com.test.config;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.concurrent.Executors;
import java.util.function.Consumer;

public class ShellCmd {

	private static class StreamGobbler implements Runnable {
        private InputStream inputStream;
        private Consumer<String> consumer;

        public StreamGobbler(InputStream inputStream, Consumer<String> consumer) {
            this.inputStream = inputStream;
            this.consumer = consumer;
        }

		@Override
		public void run() {

        	new BufferedReader(new InputStreamReader(inputStream)).lines()
                        .forEach(consumer);

        }
    }

	private static void processBuilder(boolean isWindows) throws IOException, InterruptedException {

		String homeDirectory = System.getProperty("user.home");

		ProcessBuilder builder = new ProcessBuilder();
		builder.directory(new File(homeDirectory));

		if(isWindows) {
			builder.command("cmd.exe", "/c", "D:\\appium_workspace\\run.bat ");
		}else {
			builder.command("sh", "-c", "/home/uptemto/Desktop/appiumtest/appium_workspace/run.sh");
		}

		Process process = builder.start();
		StreamGobbler streamGobbler = new StreamGobbler(process.getInputStream(), System.out::println);
	    Executors.newSingleThreadExecutor().submit(streamGobbler);

		int exitCode = process.waitFor();
	    assert exitCode == 0;


	}

    public static void cmdRun() throws IOException, InterruptedException {

        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");

        System.out.println("실행환경이 윈도우인가? " + isWindows);

        processBuilder(isWindows);

    }
}
