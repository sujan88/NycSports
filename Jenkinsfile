node {
	//Make the code checkout stage
	stage 'Checkout'
	git url: 'https://github.com/sujan88/NycSports.git'
	
	def mvnHome = tool 'LocalMAVENT'
	
	stage 'Build'
	//Run the maven build
	sh "${mvnHome}/bin/mvn -Dmaven.test.failure.ignore clean package"
	step([$class: 'JUnitResultArchiver', testResults: '**/target/surefire-reports/TEST-*.xml'])
}