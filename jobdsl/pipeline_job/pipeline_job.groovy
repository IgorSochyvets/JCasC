pipelineJob("pipeline_job") {
	description("this it testing DSL Pipeline Job ")
	keepDependencies(false)
	parameters {
		stringParam("deployTag", "Null", "Docker image tag to be deployed")
	}
	definition {
		cpsScm {
			scm {
				git {
					remote {
						url ('git@github.com:IgorSochyvets/JCasC.git')
					}
					branch("*/master")
				}
			}
			scriptPath("./Jenkinsfiles/Jenkinsfile")
		}
	}
	disabled(false)
	configure {
		it / 'properties' / 'com.coravy.hudson.plugins.github.GithubProjectProperty' {
			'projectUrl'('git@github.ibm.com:maxcloud/dev-maxcloud.git/')
			displayName()
		}
	}
}

