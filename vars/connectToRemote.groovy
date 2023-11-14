def call(node) {

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
              uname -a
           '''
        echo "${remote.name} connection successful"
    }
}