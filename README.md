# Scheduler Application

This application is a spring boot application which designed to run a scheduler tasks.  The scheduler uses **@Scheduled** annotation to run
the given tasks.  The **@Scheduled** annotation is configured to use cron scheduler.  For more information on how to configure the cron
syntax refer to [cron syntax](http://docs.spring.io/spring/docs/current/javadoc-api/org/springframework/scheduling/support/CronSequenceGenerator.html)

This application uses java `Runtime.exec()`

This application uses two properties

  * command - command to execute
  * workdir (optional) - Working directory where from the command needs to be executed
  * schedule - cron schedule syntax

## Build Instructions

This project is a `mvn` based project and requires Java 1.7+

Download code from repository

`git clone https://github.com/kesavkolla/Scheduler.git`

Create archive

`mvn package`


## Running the scheduler

`java -jar scheduler-1.0.jar --command="ls -l" --workdir="/tmp" --schedule="0 0 4 * * *"`

