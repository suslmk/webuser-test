pipeline {
  environment {
    imagename = "suslmk/dashboard01"
    registryCredential = 'f88cb9e0-bf0a-4a4f-8fef-b5e2497b7fce'
    dockerImage = ''
    privateURL = "13.209.37.23:5000"
  }
  agent any
  stages {
    stage('Cloning Github') {
      steps {
        git branch: 'master', credentialsId: 'suslmk-lee', url: 'https://github.com/suslmk-lee/dashboard-test'
      }
    }
	stage('Environment') {
            parallel {
                stage('wrapper') {
                    steps {
                        sh 'gradle wrapper'
                    }
                }
                stage('display') {
                    steps {
                        sh 'ls -la'
                    }
                }
            }
        }
	stage('Build Jar') {
            steps {
                sh './gradlew build'
            }
        }
    stage('Building image') {
      steps{
        script {
          dockerImage = docker.build imagename
        }
      }
    }
    //stage('Deploy Image') {
    //  steps{
    //    script {
    //      docker.withRegistry('http://'+privateURL, registryCredential) {
    //        dockerImage.push("$BUILD_NUMBER")
    //         dockerImage.push('latest')
    //      }
    //    }
    //  }
    //}
    //stage('Kubernetes test') {
    //	steps{
	//          sh("kubectl --kubeconfig /home/ubuntu/admin.conf get pod")
	//    }
	//}
    stage('Kubernetes deploy') {
		steps {
			kubernetesDeploy (
				configs: "Deployment.yaml", 
				kubeconfigId: '23b61cff-a44f-4199-9576-38b5642ab823', 
				enableConfigSubstitution: true
				//sh "kubectl --kubeconfig=/root/.jenkins/.kube/config rollout restart deployment/wildfly-deployment"
				//kubernetesDeploy configs: 'hello-kubernetes-dep.yaml', kubeConfig: [path: ''], kubeconfigId: '13d30c98-310b-40a9-95bd-a05e7ab49d21', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
			)
		}
	}
    //stage('Remove Unused docker image') {
    //  steps{
    //    sh "docker rmi $privateURL/$imagename:$BUILD_NUMBER"
    //     sh "docker rmi $privateURL/$imagename:latest"
    //  }
    //}
  }
}