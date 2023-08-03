def call(body) {
 
  echo "Start Sonar Scans"
  def scannerHome = tool 'ibt-sonarqube';
  
  withSonarQubeEnv(credentialsId: 'student-sonar-token', installationName: 'IBT sonarqube') {
    sh "${scannerHome}/bin/sonar-scanner"
  }
}
