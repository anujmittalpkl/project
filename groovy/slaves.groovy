import jenkins.model.*
import hudson.model.*
import hudson.slaves.*

Jenkins.instance.addNode(
  new DumbSlave(
    "testx-script",
    "test slave description",
    "/export/home/pe-deploy/",
    "5",
    Node.Mode.NORMAL,
    "test-slave-label",
    new JNLPLauncher(),
    new RetentionStrategy.Always(),
    new LinkedList()))
