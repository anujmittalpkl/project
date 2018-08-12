import jenkins.model.*
import hudson.security.*
import jenkins.security.s2m.AdminWhitelistRule
import hudson.model.*
import hudson.slaves.*
 
def instance = Jenkins.getInstance()
 
def hudsonRealm = new HudsonPrivateSecurityRealm(false)
hudsonRealm.createAccount("admin", "admin")
instance.setSecurityRealm(hudsonRealm)
 
def strategy = new FullControlOnceLoggedInAuthorizationStrategy()
instance.setAuthorizationStrategy(strategy)
instance.save()
 
Jenkins.instance.getInjector().getInstance(AdminWhitelistRule.class).setMasterKillSwitch(false)

Jenkins.instance.addNode(
  new DumbSlave(
    "test-script",
    "test slave description",
    "/export/home/pe-deploy/",
    "4",
    Node.Mode.NORMAL,
    "maven",
    new JNLPLauncher(),
    new RetentionStrategy.Always(),
    new LinkedList()))
