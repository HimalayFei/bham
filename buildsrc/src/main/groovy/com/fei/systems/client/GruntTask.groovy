
package com.fei.systems.client

import org.apache.tools.ant.taskdefs.condition.Os
import org.gradle.api.tasks.Exec

class GruntTask extends Exec {
	private String gruntExecutable = Os.isFamily(Os.FAMILY_WINDOWS) ? "grunt.cmd" : "grunt"
	private String switches = "--no-color"

	String gruntArgs = ""

	public GruntTask() {
		super()
		this.setExecutable(gruntExecutable)
	}

	public void setGruntArgs(String gruntArgs) {
		this.args = "$switches $gruntArgs".trim().split(" ") as List
	}
}

//
//class GruntTask extends Exec {
//	private String gruntExecutable = Os.isFamily(Os.FAMILY_WINDOWS) ? "grunt.cmd" : "grunt"
//	def gruntArgs = ""
//	def output = new ByteArrayOutputStream()
//	def File outputFile = null
//	
//	public GruntTask() {
//		super()
//		this.setExecutable(gruntExecutable)
//		// Don't fail immediately after executing the command, we must save the output to a file first...
//		this.setIgnoreExitValue(true)
//		// Capture output...
//		this.setStandardOutput(output)
//		this.setErrorOutput(output)
//	}
//	
//	public void setGruntArgs(String gruntArgs) {
//		this.args = "$gruntArgs".trim().split(" ") as List
//		
//		// Construct an output file name with gruntArgs...
//		def reportsDir = new File(project.buildDir, "reports")
//		this.outputFile = new File(reportsDir, gruntArgs +".txt")
//		this.outputs.file outputFile
//		
//		// After executing command...
//		this.doLast {
//		
//			// Save output to a file
//			output.close()
//			outputFile.parentFile.mkdirs()
//			outputFile.text = output.toString()
//			
//			// Log errors (if any)
//			def result = getExecResult()
//		
//			if (result.exitValue != 0) {
//				logger.error(output.toString())
//			}
//			
//			// Fail build if Grunt failed
//			result.assertNormalExitValue()
//		}
//	}
//
//	
//}
	
	
	