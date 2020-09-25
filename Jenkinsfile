pipeline {
	environment {
		IMAGE_NAME = "webuser"
		REGISTRY_CREDENTIAL = '906a7514-910d-4992-a42c-b4bbfe7eea34'
		REGISTRY_URL = "3.34.129.44:5000"
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
					dockerImage = docker.build REGISTRY_URL
				}
			}
		}
		stage('Deploy Image') {
			steps{
				script {
					docker.withRegistry("http://"+REGISTRY_URL) 
					{
						dockerImage.push("$BUILD_NUMBER")
						dockerImage.push('latest')
					}
				}
			}
		}
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
		stage('Kubernetes service deploy') {
			steps{
				sh("kubectl --kubeconfig /home/ubuntu/admin.conf -n default delete service webuser-deployment")
				sh("kubectl --kubeconfig /home/ubuntu/admin.conf -n default expose deployment webuser-deployment")
			}
		}
		stage('Remove Unused docker image') {
			steps{
				echo "REGISTRY_URL: $REGISTRY_URL"
				echo "IMAGE_NAME: $IMAGE_NAME"
				echo "BUILD_NUMBER: $BUILD_NUMBER"
				sh "docker rmi $REGISTRY_URL/$IMAGE_NAME:$BUILD_NUMBER"
				sh "docker rmi $REGISTRY_URL/$IMAGE_NAME:latest"
			}
		}
	}
}
