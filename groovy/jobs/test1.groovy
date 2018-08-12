import hudson.model.*
import jenkins.model.Jenkins;
import hudson.tasks.Shell;
job = Jenkins.instance.createProject(FreeStyleProject, 'test1')
job.buildersList.add(new Shell('echo hello world'))
job.save()