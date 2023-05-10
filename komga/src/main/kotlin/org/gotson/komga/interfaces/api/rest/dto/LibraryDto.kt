package org.gotson.komga.interfaces.api.rest.dto

import org.gotson.komga.domain.model.Library
import org.gotson.komga.infrastructure.web.toFilePath

data class LibraryDto(
  val id: String,
  val name: String,
  val root: String,
  val importComicInfoBook: Boolean,
  val importComicInfoSeries: Boolean,
  val importComicInfoCollection: Boolean,
  val importComicInfoReadList: Boolean,
  val importComicInfoSeriesAppendVolume: Boolean,
  val importEpubBook: Boolean,
  val importEpubSeries: Boolean,
  val importMylarSeries: Boolean,
  val importLocalArtwork: Boolean,
  val importBarcodeIsbn: Boolean,
  val scanForceModifiedTime: Boolean,
  val scanDeep: Boolean,
  val repairExtensions: Boolean,
  val convertToCbz: Boolean,
  val emptyTrashAfterScan: Boolean,
  val seriesCover: SeriesCoverDto,
  val hashFiles: Boolean,
  val hashPages: Boolean,
  val analyzeDimensions: Boolean,
  val unavailable: Boolean,
  val storageType: String,
)

fun Library.toDto(includeRoot: Boolean) = LibraryDto(
  id = id,
  name = name,
  root = if (includeRoot) this.root.toFilePath() else "",
  importComicInfoBook = importComicInfoBook,
  importComicInfoSeries = importComicInfoSeries,
  importComicInfoCollection = importComicInfoCollection,
  importComicInfoReadList = importComicInfoReadList,
  importComicInfoSeriesAppendVolume = importComicInfoSeriesAppendVolume,
  importEpubBook = importEpubBook,
  importEpubSeries = importEpubSeries,
  importMylarSeries = importMylarSeries,
  importLocalArtwork = importLocalArtwork,
  importBarcodeIsbn = importBarcodeIsbn,
  scanForceModifiedTime = scanForceModifiedTime,
  scanDeep = scanDeep,
  repairExtensions = repairExtensions,
  convertToCbz = convertToCbz,
  emptyTrashAfterScan = emptyTrashAfterScan,
  seriesCover = seriesCover.toDto(),
  hashFiles = hashFiles,
  hashPages = hashPages,
  analyzeDimensions = analyzeDimensions,
  unavailable = unavailableDate != null,
  storageType = storageType
)
