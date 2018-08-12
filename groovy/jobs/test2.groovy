import hudson.model.*
import jenkins.model.Jenkins;
import hudson.tasks.Shell;
job = Jenkins.instance.createProject(FreeStyleProject, 'test2')
job.buildersList.add(new Shell('echo hello world'))
job.save()