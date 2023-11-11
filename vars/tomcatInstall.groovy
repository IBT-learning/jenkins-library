def call(body, node) {

    def remote = [:]
    remote.name = node.name
    remote.host = node.ip
    withCredentials([usernamePassword(credentialsId: 'digital-smorel-server-id', passwordVariable: 'password', usernameVariable: 'username')]) {
        remote.user = username
        remote.password = password
        remote.allowAnyHosts = true
        echo 'JVM Installation ...'
        sshCommand remote: remote, command: '''
                                        sudo apt update
                                        sudo apt install -y default-jdk
                                        java --version
                                        '''
        echo 'JVM Installation Successful'
        echo 'Tomcat Server Installation ...'
        sshCommand remote: remote, command: '''
                                        sudo useradd -r -m -U -d /opt/tomcat -s /bin/false tomcat
                                        wget -c https://downloads.apache.org/tomcat/tomcat-9/v9.0.82/bin/apache-tomcat-9.0.82.tar.gz
                                        cp apache-tomcat-9.0.82.tar.gz /opt/tomcat/
                                        cd /opt/tomcat
                                        tar -xvf apache-tomcat-9.0.82.tar.gz
                                        sudo chown -R tomcat:/opt/tomcat/*
                                        cd apache-tomcat-9.0.82/bin
                                        ./startup.sh
                                        sudo ufw allow 8080/tcp
                                        '''
        echo 'Tomcat Apache Server installation successful'
    }
}