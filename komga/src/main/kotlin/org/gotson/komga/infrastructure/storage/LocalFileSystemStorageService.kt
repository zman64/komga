package org.gotson.komga.infrastructure.storage

import java.io.InputStream
import java.nio.file.Path

class LocalFileSystemStorageService : IStorageService {

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

    override fun isReadable(path: String): Boolean {
    }
}
