def call(body) {
 
  dependencyCheck additionalArguments: '''
         -o "./"
         -s "./"
         -f "ALL"
         --prettyPrint''', odcInstallation: 'dependency-check'

  dependencyCheckPublisher pattern: 'dependency-check-report.xml'
}
