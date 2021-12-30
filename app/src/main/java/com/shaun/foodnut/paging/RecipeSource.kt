package com.shaun.foodnut.paging

import android.net.Uri
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.shaun.foodnut.models.recipes.Hits
import com.shaun.foodnut.repository.HomeRepository

class RecipeSource(
    private val query: String,
    private val homeRepository: HomeRepository
) : PagingSource<Pair<String, String?>, Hits>() {


    override fun getRefreshKey(state: PagingState<Pair<String, String?>, Hits>): Pair<String, String>? {
        return null
    }

    override suspend fun load(params: LoadParams<Pair<String, String?>>): LoadResult<Pair<String, String?>, Hits> {

        return try {
            val nextPageQuery = query
            val nextPageLink = params.key?.second
            val result = homeRepository.getRecipes(query = nextPageQuery, nextPage = nextPageLink)
            LoadResult.Page(
                data = result.hits,
                prevKey = null,
                nextKey = Pair(nextPageQuery, result._links?.next?.href?.let { getQuery(it) })
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}


fun getQuery(url: String): String? {
    return try {
        val uri = Uri.parse(url)
        val queries = uri.getQueryParameter("_cont")
        queries
    } catch (e: Exception) {
        null
    }
}