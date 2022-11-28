from youtube_search import YoutubeSearch
import sys
def search(query: str):
    results = YoutubeSearch(query, max_results=10).to_json()


    file = open("result.json", "w")

    file.write(results)

    file.close()


if __name__ == "__main__":
    search(sys.argv[1])