pipeline {
  environment {
    imagename = "3.34.129.44:5000/webuser"
    registryCredential = '906a7514-910d-4992-a42c-b4bbfe7eea34'
    dockerImage = ''
    privateURL = "3.34.129.44:5000"
  }
  agent any
  parameters {
        string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
 
        text(name: 'BIOGRAPHY', defaultValue: '', description: 'Enter some information about the person')
 
        booleanParam(name: 'TOGGLE', defaultValue: true, description: 'Toggle this value')
 
        choice(name: 'CHOICE', choices: ['One', 'Two', 'Three'], description: 'Pick something')
 
        password(name: 'PASSWORD', defaultValue: 'SECRET', description: 'Enter a password')
  }
  stages {
    stage('Example') {
            input {
                message "Should we continue?"
                ok "Yes, we should."
                submitter "alice,bob"
                parameters {
                    string(name: 'PERSON', defaultValue: 'Mr Jenkins', description: 'Who should I say hello to?')
                }
            }
            steps {
                echo "Hello, ${PERSON}, nice to meet you."
            }
        }
    stage('Example') {
            steps {
                echo "Hello ${params.PERSON}"
 
                echo "Biography: ${params.BIOGRAPHY}"
 
                echo "Toggle: ${params.TOGGLE}"
 
                echo "Choice: ${params.CHOICE}"
 
                echo "Password: ${params.PASSWORD}"
        }
    }
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
				//sh "kubectl --kubeconfig /home/ubuntu/admin.conf -n default delete service webuser-deployment"
				//sh "kubectl --kubeconfig=/root/.jenkins/.kube/config rollout restart deployment/wildfly-deployment"
				//kubernetesDeploy configs: 'hello-kubernetes-dep.yaml', kubeConfig: [path: ''], kubeconfigId: '13d30c98-310b-40a9-95bd-a05e7ab49d21', secretName: '', ssh: [sshCredentialsId: '*', sshServer: ''], textCredentials: [certificateAuthorityData: '', clientCertificateData: '', clientKeyData: '', serverUrl: 'https://']
			)
		}
	}
	//stage('Kubernetes service deploy') {
    //	steps{
	          //sh("kubectl --kubeconfig /home/ubuntu/admin.conf -n default delete service webuser-deployment")
			  //sh("kubectl --kubeconfig /home/ubuntu/admin.conf -n default expose deployment webuser-deployment")
	//    }
	//}
    //stage('Remove Unused docker image') {
    //  steps{
    //    sh "docker rmi $privateURL/$imagename:$BUILD_NUMBER"
    //     sh "docker rmi $privateURL/$imagename:latest"
    //  }
    //}
  }
}
