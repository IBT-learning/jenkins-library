def call(body) {
 
  echo "Start Sonar Scans"
  def scannerHome = tool 'ibt-sonarqube';
  
  withSonarQubeEnv(credentialsId: 'SQ-student', installationName: 'IBT sonarqube') {
    sh "${scannerHome}/bin/sonar-scanner"
  }
}
