package org.gotson.komga.infrastructure.storage

import software.amazon.awssdk.auth.credentials.DefaultCredentialsProvider
import software.amazon.awssdk.regions.Region
import software.amazon.awssdk.services.s3.S3Client
import software.amazon.awssdk.services.s3.model.GetObjectAclRequest

class S3StorageService(
// constructor parameters
) : IStorageService {
    // implementation of the IStorageService methods
    override fun listFiles(directory: String): List<Path> {
        // Implement local file system method for listing files
    }

    override fun readFileContent(path: String): InputStream {
        // Implement local file system method for reading file content
    }

    override fun writeFileContent(path: String, content: InputStream): Path {
        // Implement local file system method for writing file content
    }

    // Implement any other necessary methods for storage operations
    override fun isDirectory(path: String): Boolean {
    }

    fun main() {
        val path = "s3://your-bucket-name/your-object-key"
        println("Is readable: ${isReadable(path)}")
    }

    override fun isReadable(path: String): Boolean {
        val (bucket, key) = parseS3Path(path)

        val s3Client =
                S3Client.builder()
                        .region(Region.US_EAST_1) // You can set the region according to your needs
                        .credentialsProvider(DefaultCredentialsProvider.create())
                        .build()

        return try {
            val getObjectAclRequest = GetObjectAclRequest.builder().bucket(bucket).key(key).build()

            s3Client.getObjectAcl(getObjectAclRequest)
            true
        } catch (e: Exception) {
            println("Error: ${e.message}")
            false
        }
    }

    fun parseS3Path(path: String): Pair<String, String> {
        val regex = """s3://([^/]+)/(.+)""".toRegex()
        val matchResult =
                regex.matchEntire(path)
                        ?: throw IllegalArgumentException("Invalid S3 path format: $path")

        val (bucket, key) = matchResult.destructured
        return bucket to key
    }
}
