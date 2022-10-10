

#!/usr/bin/env groovy

def call(body) {
    echo "Start Deploy"
    def remote = [name: 'tomcat-dev', host: '68.183.51.116', user: 'root', allowAnyHosts: true]
    withCredentials([sshUserPrivateKey(credentialsId: "vm-ssh", keyFileVariable: 'identity')]) {
       remote.identityFile = identity
       sshPut remote: remote, from: 'target/hello-maven-1.0-SNAPSHOT.war', into: '/opt/tomcat10/webapps/'
    }
    echo "Deployed"
    currentBuild.result = 'SUCCESS' //FAILURE to fail

    return this
}
