#!/usr/bin/env groovy

def call(body) {
    echo "Start Deploy"

    new Deployer(script:this).run()
    echo "Blaise"
    currentBuild.result = 'SUCCESS' //FAILURE to fail

    return this
}
