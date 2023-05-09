package org.gotson.komga.infrastructure.storage

import java.io.InputStream
import java.nio.file.Path

interface IStorageService {

    fun listFiles(directory: String): List<Path>

    fun readFileContent(path: String): InputStream

    fun writeFileContent(path: String, content: InputStream): Path

    // Add any other necessary methods for storage operations
}
