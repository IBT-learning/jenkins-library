def call(body, node) {

    def remote = [:]
    remote.name = node.name
    remote.host = node.ip
    withCredentials([usernamePassword(credentialsId: 'digital-smorel-server-id', passwordVariable: 'password', usernameVariable: 'username')]) {
        remote.user = username
        remote.password = password
        remote.allowAnyHosts = true

        echo "Connected to remote mode [${remote.name}]..."
        sh '''
              java --version
              ls -lrst /opt/tomcat/apache-tomcat-9.0.82
              cd /opt/tomcat/apache-tomcat-9.0.82/webapps
              java -cp ibt-maven-2.9-SNAPSHOT.jar com.ibt.app/App
           '''
        echo "${remote.name} connection successful"
    }
}