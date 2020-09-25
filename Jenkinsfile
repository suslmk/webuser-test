pipeline {
  environment {
    imagename = "3.34.129.44:5000/webuser"
    registryCredential = '906a7514-910d-4992-a42c-b4bbfe7eea34'
    dockerImage = ''
    privateURL = "13.209.37.23:5000"
  }
  agent any
  stages {
    stage('Cloning Github') {
      steps {
        git branch: 'dev', credentialsId: 'suslmk-lee', url: 'https://github.com/suslmk-lee/webuser-test'
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
	stage('Clean Build') {
            steps {
                sh './gradlew clean'
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
    stage('Deploy Image') {
      steps{
        script {
          docker.withRegistry('http://'+privateURL) 
		  {
            dockerImage.push("$BUILD_NUMBER")
            dockerImage.push('latest')
          }
        }
      }
    }
    //stage('Kubernetes test') {
    //	steps{
	//          sh("kubectl --kubeconfig /home/ubuntu/admin.conf get pod")
	//    }
	//}
    stage('Kubernetes deploy') {
		steps {
			kubernetesDeploy (
				configs: "yaml/Deployment.yaml", 
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
