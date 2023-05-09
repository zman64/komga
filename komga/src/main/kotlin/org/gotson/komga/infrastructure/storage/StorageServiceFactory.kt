package org.gotson.komga.infrastructure.storage

import org.gotson.komga.infrastructure.configuration.KomgaProperties
import org.springframework.stereotype.Component

@Component
class StorageServiceFactory(
    private val komgaProperties: KomgaProperties,
    private val localFileSystemStorageService: LocalFileSystemStorageService,
    private val s3StorageService: S3StorageService
) {
    fun getStorageService(): IStorageService {
        return when (komgaProperties.storageType.lowercase()) {
            "local" -> localFileSystemStorageService
            "s3" -> s3StorageService
            else -> throw IllegalArgumentException("Invalid storage type: ${komgaProperties.storageType}")
        }
    }
}
