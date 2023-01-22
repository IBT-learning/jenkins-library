def call(body) {
 
  echo "Start Sonar Scans"
  environment {
      scannerHome = tool 'ibt-sonarqube';
      }
   steps {
       sh 'echo performing sonar scans'
       withSonarQubeEnv(credentialsId: 'SQ-student', installationName: 'IBT sonarqube') {
       sh "${scannerHome}/bin/sonar-scanner"
        }
       }
}
