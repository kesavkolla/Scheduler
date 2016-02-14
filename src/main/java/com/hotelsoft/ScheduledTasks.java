package com.hotelsoft;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;


@Component
public class ScheduledTasks {
	final Logger LOGGER = LoggerFactory.getLogger(getClass().getName());
	private
	@Value("${command}")
	String command;

	private
	@Value("${workdir:}")
	String workdir;

	@Scheduled(cron = "${schedule}")
	public void executeCommand() throws IOException {
		final File workdir =
				(this.workdir == null || this.workdir.trim().length() < 1) ? null : Paths.get(this.workdir).toFile();
		try (final Scanner scanner = new Scanner(
				Runtime.getRuntime().exec(command, null, workdir).getInputStream())) {
			while (scanner.hasNext()) {
				LOGGER.info(scanner.nextLine());
			}
		}
	}
}
