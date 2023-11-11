def call(body) {
 
  echo "Start Sonar Scans"
  def scannerTool = tool 'ibt-sonarqube_4.8'
  
  withSonarQubeEnv(credentialsId: 'student-sonar-token', installationName: 'IBT sonarqube') {
    sh 'echo Staring code check scan in [$BRANCH_NAME] git branch'
    sh "${scannerTool}/bin/sonar-scanner"
  }
}
