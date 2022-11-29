from youtube_search import YoutubeSearch
import sys
def search(query: str, max_result: int):
    results = YoutubeSearch(query, max_results=max_result).to_json()


    file = open("result.json", "w")

    file.write(results)

    file.close()


if __name__ == "__main__":
    max_res = 10
    if len(sys.argv) > 2:
        max_res = int(sys.argv[2])
        print(max_res)

    search(sys.argv[1], max_res)