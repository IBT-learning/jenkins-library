def call(body, node) {

    def remote = [:]
    remote.name = node.name
    remote.host = node.ip
    withCredentials([usernamePassword(credentialsId: 'digital-smorel-server-id', passwordVariable: 'password', usernameVariable: 'username')]) {
        remote.user = username
        remote.password = password
        remote.allowAnyHosts = true

        echo 'Artifact Deployment start ...'
        sshPut remote: remote, from: 'target/ibt-maven-2.9-SNAPSHOT.jar', into: '/opt/tomcat/apache-tomcat-9.0.82/webapps'
        sshCommand remote: remote, command: '''
                                                    cd /opt/tomcat/apache-tomcat-9.0.82/webapps
                                                    java -cp ibt-maven-2.9-SNAPSHOT.jar com.ibt.app/App
                                                    '''
        echo "${remote.name} deployment successful"
    }
}